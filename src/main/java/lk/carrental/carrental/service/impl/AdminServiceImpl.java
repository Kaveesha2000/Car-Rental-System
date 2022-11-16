package lk.carrental.carrental.service.impl;


import lk.carrental.carrental.dto.AdminDTO;
import lk.carrental.carrental.entity.Admin;
import lk.carrental.carrental.repo.AdminRepo;
import lk.carrental.carrental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminId())) {
            repo.save(mapper.map(dto, Admin.class));
        }else {
            throw new RuntimeException("Admin Already Exist...!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminId())){
            repo.save(mapper.map(dto,Admin.class));
        }else {
            throw new RuntimeException("No such admin. Try again...!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(),AdminDTO.class);
        }else {
            throw new RuntimeException("No admin for the id "+id+". Try again...!");
        }
    }

    @Override
    public String generateAdminIds() {
        return repo.generateAdminId();
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(), new TypeToken<List<AdminDTO>>() {
        }.getType());
    }
}
