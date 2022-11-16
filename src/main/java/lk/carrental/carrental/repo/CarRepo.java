package lk.carrental.carrental.repo;

import lk.carrental.carrental.dto.CarDTO;
import lk.carrental.carrental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT carId FROM Car ORDER BY carId DESC LIMIT 1", nativeQuery = true)
    String generateCarId();

    @Query(value = "SELECT COUNT(*) FROM Car WHERE availableOrNot=:availableOrNot", nativeQuery = true)
    int registeredCarCount(@Param("availableOrNot") String availableOrNot);

    @Query(value = "SELECT COUNT(*) FROM Car WHERE underMaintainanceOrNot=:underMaintainanceOrNot", nativeQuery = true)
    int underMaintainanceOrNot(@Param("underMaintainanceOrNot") String underMaintainanceOrNot);

    @Query(value = "UPDATE Car SET availableOrNot=:available WHERE carId=:carId", nativeQuery = true)
    String carAvailableOrNot(@Param("available") String available, @Param("carId") String carId);

    @Query(value = "SELECT * FROM Car ORDER BY noOfPassengers ASC", nativeQuery = true)
    List<CarDTO> sortByNoOfPassengersByAsc();

    @Query(value = "SELECT * FROM Car ORDER BY noOfPassengers DESC", nativeQuery = true)
    List<CarDTO> sortByNoOfPassengersByDsc();

    @Query(value = "SELECT * FROM Car ORDER BY monthlyRatePrice ASC", nativeQuery = true)
    List<CarDTO> sortByMonthlyRatePriceByAsc();

    @Query(value = "SELECT * FROM Car ORDER BY monthlyRatePrice DESC", nativeQuery = true)
    List<CarDTO> sortByMonthlyRatePriceByDsc();

    @Query(value = "SELECT * FROM Car ORDER BY dailyRatePrice ASC", nativeQuery = true)
    List<CarDTO> sortByDailyRatePriceByAsc();

    @Query(value = "SELECT * FROM Car ORDER BY dailyRatePrice DESC", nativeQuery = true)
    List<CarDTO> sortByDailyRatePriceByDsc();

    @Query(value = "SELECT * FROM Car WHERE transmissionType=:transmissionType", nativeQuery = true)
    List<CarDTO> sortByTransmissionType(@Param("transmissionType") String transmissionType);

    @Query(value = "SELECT * FROM Car WHERE brand=:brand", nativeQuery = true)
    List<CarDTO> sortByBrand(@Param("brand") String brand);

    @Query(value = "SELECT * FROM Car WHERE carType", nativeQuery = true)
    List<CarDTO> sortByType(@Param("carType") String carType);

    @Query(value = "SELECT * FROM Car ORDER BY fuelType", nativeQuery = true)
    List<CarDTO> sortByFuelType(@Param("fuelType") String fuelType);
}
