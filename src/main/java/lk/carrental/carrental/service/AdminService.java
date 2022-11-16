package lk.carrental.carrental.service;

import lk.carrental.carrental.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO dto);
    void updateAdmin(AdminDTO dto);
    AdminDTO searchAdmin(String id);
    String generateAdminIds();
    List<AdminDTO> getAllAdmin();
}
