package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReserveRepo extends JpaRepository<Reserve,String> {
    @Query(value = "SELECT reserveId FROM Reserve ORDER BY reserveId DESC LIMIT 1", nativeQuery = true)
    String generateReserveId();

    @Query(value = "SELECT COUNT(*) FROM Reserve WHERE bookingDate:bookingDate", nativeQuery = true)
    int countDailyReservations(@Param("bookingDate") String bookingDate);

    @Query(value = "SELECT COUNT(*) FROM Reserve WHERE acceptOrDeny:acceptedRequests", nativeQuery = true)
    int activeReservationPerDay(@Param("acceptedRequests") String acceptedRequests);
}
