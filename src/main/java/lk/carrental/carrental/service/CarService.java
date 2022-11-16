package lk.carrental.carrental.service;

import lk.carrental.carrental.dto.CarDTO;

import java.util.List;

public interface CarService {

    //CRUD
    void saveCar(CarDTO dto);
    void deleteCar(String id);
    void updateCar(CarDTO dto);
    CarDTO searchCar(String id);
    List<CarDTO> getAllCar();
    String generateCarIds();

    //counts
    int availableCount(String availableOrNot);
    int reserveCount(String availableOrNot);
    int needMaintainceCount(String underMaintainanceOrNot);
    int underMaintainceCount(String underMaintainanceOrNot);

    //sorting methods
    List<CarDTO> sortByNoOfPassengersByAsc();
    List<CarDTO> sortByNoOfPassengersByDsc();
    List<CarDTO> sortByMonthlyRatePriceByAsc();
    List<CarDTO> sortByMonthlyRatePriceByDsc();
    List<CarDTO> sortByDailyRatePriceByAsc();
    List<CarDTO> sortByDailyRatePriceByDsc();
    List<CarDTO> sortByTransmissionType(String transmissionType);
    List<CarDTO> sortByBrand(String brand);
    List<CarDTO> sortByType(String type);
    List<CarDTO> sortByFuelType(String fuelType);
}
