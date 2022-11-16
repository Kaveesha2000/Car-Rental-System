package lk.carrental.carrental.repo;

import lk.carrental.carrental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "SELECT driverId FROM Driver ORDER BY driverId DESC LIMIT 1", nativeQuery = true)
    String generateDriverId();

    @Query(value = "select * from Driver", nativeQuery = true)
    List<Driver> getAllDriver();

    @Query(value = "select COUNT(*) from Driver where driverReleaseOrNot=:driverReleaseOrNot",nativeQuery = true)
    String releaseOrNotCount(@Param("driverReleaseOrNot") String driverReleaseOrNot);

    @Query(value = "UPDATE Driver SET driverReleaseOrNot=:release WHERE driverId=:driverId", nativeQuery = true)
    void updateDriverIfHeReleaseOrNot(@Param("release") String release, @Param("driverId") String driverId);

}

