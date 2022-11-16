package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.AdminDTO;
import lk.carrental.carrental.service.AdminService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO adminDTO){
        adminService.saveAdmin(adminDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(adminDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{adminId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String adminId){
        return new ResponseUtil(200,"Ok",adminService.searchAdmin(adminId));
    }

    @GetMapping(params = {"adminId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateAdminIds(@RequestParam String adminId){
        return new ResponseUtil(200,"Ok",adminService.generateAdminIds());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmins(){
        return new ResponseUtil(200,"All the customers are loaded",adminService.getAllAdmin());
    }

}
