package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.ScheduleDTO;
import lk.carrental.carrental.entity.Schedule;
import lk.carrental.carrental.repo.ScheduleRepo;
import lk.carrental.carrental.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveSchedule(ScheduleDTO dto) {
        if (!repo.existsById(dto.getScheduleId())) {
            repo.save(mapper.map(dto, Schedule.class));
        }else {
            throw new RuntimeException("Schedule Already Exist...!");
        }
    }

    @Override
    public void updateSchedule(ScheduleDTO dto) {
        if (repo.existsById(dto.getScheduleId())){
            repo.save(mapper.map(dto,Schedule.class));
        }else {
            throw new RuntimeException("No such schedule. Try again...!");
        }
    }

    @Override
    public ScheduleDTO searchSchedule(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), ScheduleDTO.class);
        }else {
            throw new RuntimeException("No customer for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedule() {
        return mapper.map(repo.findAll(), new TypeToken<List<ScheduleDTO>>() {
        }.getType());
    }

    @Override
    public String generateScheduleIds() {
        return repo.generateScheduleId();
    }
}
