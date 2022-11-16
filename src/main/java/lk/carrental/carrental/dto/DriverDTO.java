package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private String driverNIC;
    private String driverLicenseNo;
    private String driverPassword;
    private String driverReleaseOrNot;
}
