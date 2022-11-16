package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.ReserveDTO;
import lk.carrental.carrental.entity.*;
import lk.carrental.carrental.repo.*;
import lk.carrental.carrental.service.ReserveService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveRepo reserveRepo;

    @Autowired
    private ReserveDetailRepo reserveDetailsRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void reserve(ReserveDTO dto) {
        Reserve reserve = modelMapper.map(dto, Reserve.class);
        if (!reserveRepo.existsById(dto.getReserveId())){

            if (dto.getReserveDetailDTOList().size() < 1){
                throw new RuntimeException("No Selected Cars In Reservation..!");
            }else {
                reserveRepo.save(reserve);

                for (ReserveDetail reserveDetails : reserve.getReserveDetail()) {
                    Car car = carRepo.findById(reserveDetails.getCarId()).get();
                    Driver driver = driverRepo.findById(reserveDetails.getDriverId()).get();
                    carRepo.carAvailableOrNot("Not Available",car.getCarId()) ;
                    driverRepo.updateDriverIfHeReleaseOrNot("NO", reserveDetails.getDriverId());

                    Schedule rd = new Schedule(
                            scheduleRepo.generateScheduleId(),
                            reserve.getPickedDate(),
                            reserve.getPickedTime(),
                            reserve.getReturnDate(),
                            driver.getDriverReleaseOrNot(),
                            reserveDetails
                    );
                    scheduleRepo.save(rd);
                }
            }
        }else {
            throw  new RuntimeException(dto.getReserveId()+" "+"Reservation Already Exist..!");
        }
    }

    @Override
    public void updateReserve(ReserveDTO dto) {
        Reserve reserve = modelMapper.map(dto, Reserve.class);

        if (reserveRepo.existsById(dto.getReserveId())){
            Reserve referenceById= reserveRepo.findById(dto.getReserveId()).get();
            for (ReserveDetail reserveDetail : referenceById.getReserveDetail()) {
                driverRepo.updateDriverIfHeReleaseOrNot("Release",reserveDetail.getDriverId());
            }
        }
        if (reserveRepo.existsById(reserve.getReserveId())){
            reserveRepo.save(reserve);
            for (ReserveDetail reserveDetails : reserve.getReserveDetail()) {
                driverRepo.updateDriverIfHeReleaseOrNot("Not Release", reserveDetails.getDriverId());
                Driver driver = driverRepo.findById(reserveDetails.getDriverId()).get();

                Schedule rd = new Schedule(
                        scheduleRepo.generateScheduleId(),
                        reserve.getPickedDate(),
                        reserve.getPickedTime(),
                        reserve.getReturnDate(),
                        driver.getDriverReleaseOrNot(),
                        reserveDetails
                );
                scheduleRepo.save(rd);
            }
        }
    }

    @Override
    public ReserveDTO searchReserve(String id) {
        if (reserveRepo.existsById(id)){
            return modelMapper.map(reserveRepo.findById(id).get(), ReserveDTO.class);
        }else {
            throw new RuntimeException("No reserve for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<ReserveDTO> getAllReserve() {
        return modelMapper.map(reserveRepo.findAll(), new TypeToken<List<ReserveDTO>>() {
        }.getType());
    }

    @Override
    public String generateReserveId() {
        return reserveRepo.generateReserveId();
    }

    @Override
    public int countDailyReservation(String bookingDate) {
        return reserveRepo.countDailyReservations(bookingDate);
    }

    @Override
    public int activeReservationsPerDay(String acceptedRequests) {
        return reserveRepo.activeReservationPerDay(acceptedRequests);
    }
}
