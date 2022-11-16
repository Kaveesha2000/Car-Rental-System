package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentRepo extends JpaRepository<Rent,String> {

    @Query(value = "SELECT SUM(fullPayment) FROM Rent WHERE rentDate=:rentDate", nativeQuery = true)
    double dailyIncome(@Param("rentDate") String rentDate);

    @Query(value = "SELECT SUM(fullPayment) FROM Rent WHERE rentDate BETWEEN =:firstRentdate AND =:lastRentdate", nativeQuery = true)
    double income(@Param("firstRentdate") String firstRentdate, @Param("lastRentdate") String lastRentdate);
}
