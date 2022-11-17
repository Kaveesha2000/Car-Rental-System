package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String driverId;
    @Size(min = 3, max = 40,message = "Please enter the name correctly")
    private String driverName;
    @Size(min = 3, max = 50,message = "Please enter the address correctly")
    private String driverAddress;
    @Size(min = 10, max = 10,message = "Please enter the contact number correctly")
    private String driverContact;
    @Size(min = 12, max = 12,message = "Please enter the national identity card number correctly")
    private String driverNIC;
    @Size(min = 6, max = 6,message = "Please enter the licence number correctly")
    private String driverLicenseNo;
    @Size(min = 6, max = 40,message = "Please try to enter a strong password")
    private String driverPassword;
    @Size(min = 3, max = 7,message = "Please try to enter a strong password")
    private String driverReleaseOrNot;
}
