package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.DriverDTO;
import lk.carrental.carrental.service.DriverService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {

    final
    DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO){
        driverService.saveDriver(driverDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO){
        driverService.updateDriver(driverDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"driverId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String driverId){
        driverService.deleteDriver(driverId);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriver(){
        return new ResponseUtil(200,"All the drivers are loaded",driverService.getAllDriver());
    }

    @GetMapping(path = "/{driverId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String driverId){
        return new ResponseUtil(200,"Ok",driverService.searchDriver(driverId));
    }

    @GetMapping(params = {"driverId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateDriverIds(@RequestParam String driverId){
        return new ResponseUtil(200,"Ok",driverService.generateDriverIds());
    }

    @GetMapping(params = {"releaseOrNot"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil releaseOrNot(@PathVariable String releaseOrNot){
        return new ResponseUtil(200,"Ok",driverService.releaseOrNot(releaseOrNot));
    }
}
