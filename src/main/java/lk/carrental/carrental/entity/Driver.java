package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private String driverNIC;
    private String driverLicenseNo;
    private String driverPassword;
    private String driverReleaseOrNot;
}
