package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.DriverDTO;
import lk.carrental.carrental.entity.Driver;
import lk.carrental.carrental.repo.DriverRepo;
import lk.carrental.carrental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverId())) {
            repo.save(mapper.map(dto, Driver.class));
        }else {
            throw new RuntimeException("Driver Already Exist...!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("There is no such driver. Try again...!");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverId())){
            repo.save(mapper.map(dto,Driver.class));
        }else {
            throw new RuntimeException("No such driver. Try again...!");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), DriverDTO.class);
        }else {
            throw new RuntimeException("No driver for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public String generateDriverIds() {
        return repo.generateDriverId();
    }

    @Override
    public String releaseOrNot(String b) {
        return repo.releaseOrNotCount(b);
    }
}
