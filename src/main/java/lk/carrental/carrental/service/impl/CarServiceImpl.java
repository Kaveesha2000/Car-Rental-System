package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.CarDTO;
import lk.carrental.carrental.entity.Car;
import lk.carrental.carrental.repo.CarRepo;
import lk.carrental.carrental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        System.out.println("=========================================================");
        System.out.println(dto.toString());
        if (!repo.existsById(dto.getCarId())) {
            Car map = mapper.map(dto, Car.class);
            System.out.println(map.toString());
            repo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("Car Already Exist...!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("There is no such car. Try again...!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (repo.existsById(dto.getCarId())){
            repo.save(mapper.map(dto,Car.class));
        }else {
            throw new RuntimeException("No such car. Try again...!");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), CarDTO.class);
        }else {
            throw new RuntimeException("No car for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        return mapper.map(repo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public String generateCarIds() {
        return repo.generateCarId();
    }

    @Override
    public int availableCount(String availableOrNot) {
        return repo.registeredCarCount(availableOrNot);
    }

    @Override
    public int reserveCount(String availableOrNot) {
        return repo.registeredCarCount(availableOrNot);
    }

    @Override
    public int needMaintainceCount(String underMaintainanceOrNot) {
        return repo.underMaintainanceOrNot(underMaintainanceOrNot);
    }

    @Override
    public int underMaintainceCount(String underMaintainanceOrNot) {
        return repo.underMaintainanceOrNot(underMaintainanceOrNot);
    }

    @Override
    public List<CarDTO> sortByNoOfPassengersByAsc() {
        return repo.sortByNoOfPassengersByAsc();
    }

    @Override
    public List<CarDTO> sortByNoOfPassengersByDsc() {
        return repo.sortByNoOfPassengersByDsc();
    }

    @Override
    public List<CarDTO> sortByMonthlyRatePriceByAsc() {
        return repo.sortByMonthlyRatePriceByAsc();
    }

    @Override
    public List<CarDTO> sortByMonthlyRatePriceByDsc() {
        return repo.sortByMonthlyRatePriceByDsc();
    }

    @Override
    public List<CarDTO> sortByDailyRatePriceByAsc() {
        return repo.sortByDailyRatePriceByAsc();
    }

    @Override
    public List<CarDTO> sortByDailyRatePriceByDsc() {
        return repo.sortByDailyRatePriceByDsc();
    }

    @Override
    public List<CarDTO> sortByTransmissionType(String transmissionType) {
        return repo.sortByTransmissionType(transmissionType);
    }

    @Override
    public List<CarDTO> sortByBrand(String brand) {
        return repo.sortByBrand(brand);
    }

    @Override
    public List<CarDTO> sortByType(String type) {
        return repo.sortByType(type);
    }

    @Override
    public List<CarDTO> sortByFuelType(String fuelType) {
        return repo.sortByFuelType(fuelType);
    }
}
