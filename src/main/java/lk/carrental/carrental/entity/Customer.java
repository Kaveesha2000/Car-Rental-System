package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customerId;
    @Size(min = 3, max = 40,message = "Please enter the name correctly")
    private String customerName;
    @Size(min = 3, max = 50,message = "Please enter the address correctly")
    private String customerAddress;
    @Size(min = 10, max = 10,message = "Please enter the contact number correctly")
    private String customerContact;
    @Size(min = 12, max = 12,message = "Please enter the national identity card number correctly")
    private String customerNIC;
    @Size(min = 6, max = 6,message = "Please enter the licence number correctly")
    private String customerLicenseNo;
    @Email(message = "Please enter the email correctly")
    private String customerEmail;
    @Size(min = 6, max = 40,message = "Please try to enter a strong password")
    private String customerNewPassword;
    @Size(min = 10, max = 10,message = "Please enter the date correctly")
    private String customerRegisteredDate;

}
