package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.ScheduleDTO;
import lk.carrental.carrental.service.ScheduleService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/schedule")
@CrossOrigin
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveSchedule(@ModelAttribute ScheduleDTO scheduleDTO){
        scheduleService.saveSchedule(scheduleDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateSchedule(@RequestBody ScheduleDTO scheduleDTO){
        scheduleService.updateSchedule(scheduleDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{scheduleId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchSchedule(@PathVariable String scheduleId){
        return new ResponseUtil(200,"Ok",scheduleService.searchSchedule(scheduleId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllSchedules(){
        return new ResponseUtil(200,"All the schedules are loaded",scheduleService.getAllSchedule());
    }

    @GetMapping(params = {"scheduleId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateScheduleIds(@PathVariable String scheduleId){
        return new ResponseUtil(200,"Ok",scheduleService.generateScheduleIds());
    }

}
