package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1", nativeQuery = true)
    String generateCustomerId();

    @Query(value = "SELECT COUNT(*) FROM Customer", nativeQuery = true)
    int registeredCustomerCount();

    @Query(value = "SELECT COUNT(*) FROM Customer WHERE customerRegisteredDate=:customerRegisteredDate;", nativeQuery = true)
    int dailyRegisteredCustomerCount(@Param("customerRegisteredDate") String customerRegisteredDate);
}
