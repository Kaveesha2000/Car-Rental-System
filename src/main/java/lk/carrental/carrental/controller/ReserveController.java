package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.ReserveDTO;
import lk.carrental.carrental.service.ReserveService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reserve")
@CrossOrigin
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil reserve(@ModelAttribute ReserveDTO reserveDTO){
        reserveService.reserve(reserveDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateReserve(@RequestBody  ReserveDTO reserveDTO){
        reserveService.updateReserve(reserveDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{reserveId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchReserve(@PathVariable String reserveId){
        return new ResponseUtil(200,"Ok",reserveService.searchReserve(reserveId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllReserve(){
        return new ResponseUtil(200,"All the reserves are loaded",reserveService.getAllReserve());
    }

    @GetMapping(params = {"reserveId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateReserveIds(@PathVariable String reserveId){
        return new ResponseUtil(200,"Ok",reserveService.generateReserveId());
    }

    @GetMapping(path = "/Count/{dailyReservationsCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil dailyReservationsCount(@PathVariable String dailyReservationsCount){
        return new ResponseUtil(200,"Ok",reserveService.countDailyReservation(dailyReservationsCount));
    }

    @GetMapping(path = "/Count/{activeReservationPerDayCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil activeReservationPerDayCount(@PathVariable String activeReservationPerDayCount){
        return new ResponseUtil(200,"Ok",reserveService.activeReservationsPerDay(activeReservationPerDayCount));
    }

}
