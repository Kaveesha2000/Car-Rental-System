package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.CarDTO;
import lk.carrental.carrental.service.CarService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {

    final
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@ModelAttribute CarDTO carDTO){
        carService.saveCar(carDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO carDTO){
        carService.updateCar(carDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"carId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String carId){
        carService.deleteCar(carId);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{carId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String carId){
        return new ResponseUtil(200,"Ok",carService.searchCar(carId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCar(){
        return new ResponseUtil(200,"Ok",carService.getAllCar());
    }

    @GetMapping(params = {"carId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCarIds(@RequestParam String carId){
        return new ResponseUtil(200,"Ok",carService.generateCarIds());
    }

    @GetMapping(path = "/Count/{availableCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil availableCount(@PathVariable String availableCount){
        return new ResponseUtil(200,"Ok",carService.availableCount(availableCount));
    }

    @GetMapping(path = "/Count/{responseCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil responseCount(@PathVariable String responseCount){
        return new ResponseUtil(200,"Ok",carService.reserveCount(responseCount));
    }

    @GetMapping(path = "/Count/{needMaintainceCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil needMaintainceCount(@PathVariable String needMaintainceCount){
        return new ResponseUtil(200,"Ok",carService.needMaintainceCount(needMaintainceCount));
    }

    @GetMapping(path = "/Count/{underMaintainceCount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil underMaintainceCount(@PathVariable String underMaintainceCount){
        return new ResponseUtil(200,"Ok",carService.underMaintainceCount(underMaintainceCount));
    }

    @GetMapping(path = "/Count/{sortByNoOfPassengersByAsc}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByNoOfPassengersByAsc(@PathVariable String sortByNoOfPassengersByAsc){
        return new ResponseUtil(200,"Ok",carService.sortByNoOfPassengersByAsc());
    }

    @GetMapping(path = "/Count/{sortByNoOfPassengersByDsc}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByNoOfPassengersByDsc(@PathVariable String sortByNoOfPassengersByDsc){
        return new ResponseUtil(200,"Ok",carService.sortByNoOfPassengersByDsc());
    }

    @GetMapping(path = "/Count/{sortByMonthlyRatePriceByAsc}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByMonthlyRatePriceByAsc(@PathVariable String sortByMonthlyRatePriceByAsc){
        return new ResponseUtil(200,"Ok",carService.sortByMonthlyRatePriceByAsc());
    }

    @GetMapping(path = "/Count/{sortByMonthlyRatePriceByDsc}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByMonthlyRatePriceByDsc(@PathVariable String sortByMonthlyRatePriceByDsc){
        return new ResponseUtil(200,"Ok",carService.sortByMonthlyRatePriceByDsc());
    }

    @GetMapping(path = "/Count/{sortByDailyRatePriceByAsc}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByDailyRatePriceByAsc(@PathVariable String sortByDailyRatePriceByAsc){
        return new ResponseUtil(200,"Ok",carService.sortByDailyRatePriceByAsc());
    }

    @GetMapping(path = "/Count/{sortByDailyRatePriceByDsc}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByDailyRatePriceByDsc(@PathVariable String sortByDailyRatePriceByDsc){
        return new ResponseUtil(200,"Ok",carService.sortByDailyRatePriceByDsc());
    }

    @GetMapping(path = "/Count/{sortByTransmissionType}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByTransmissionType(@PathVariable String sortByTransmissionType){
        return new ResponseUtil(200,"Ok",carService.sortByTransmissionType(sortByTransmissionType));
    }

    @GetMapping(path = "/Count/{sortByBrand}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByBrand(@PathVariable String sortByBrand){
        return new ResponseUtil(200,"Ok",carService.sortByBrand(sortByBrand));
    }

    @GetMapping(path = "/Count/{sortByType}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByType(@PathVariable String sortByType){
        return new ResponseUtil(200,"Ok",carService.sortByType(sortByType));
    }

    @GetMapping(path = "/Count/{sortByFuelType}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil sortByFuelType(@PathVariable String sortByFuelType){
        return new ResponseUtil(200,"Ok",carService.sortByFuelType(sortByFuelType));
    }
}
