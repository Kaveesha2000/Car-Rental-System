package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.RentDTO;
import lk.carrental.carrental.service.RentService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rent")
@CrossOrigin
public class RentController {

    @Autowired
    RentService rentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRent(@ModelAttribute RentDTO rentDTO){
        rentService.saveRent(rentDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRent(@RequestBody RentDTO rentDTO){
        rentService.updateRent(rentDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{rentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRent(@PathVariable String rentId){
        return new ResponseUtil(200,"Ok",rentService.searchRent(rentId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRent(){
        return new ResponseUtil(200,"All the rents are loaded",rentService.getAllRent());
    }

    @GetMapping(path = "/{dailyIncome}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDailyIncome(@PathVariable String rentDate){
        return new ResponseUtil(200,"Ok",rentService.dailyIncome(rentDate));
    }

    @GetMapping(path = "/{firstRentDate}/{lastRentDate}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getIncome(@PathVariable String firstRentDate,@PathVariable String lastRentDate){
        return new ResponseUtil(200,"Ok",rentService.income(firstRentDate,lastRentDate));
    }
}
