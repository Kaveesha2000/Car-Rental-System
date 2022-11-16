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
public class Customer {

    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private String customerNIC;
    private String customerLicenseNo;
    private String customerEmail;
    private String customerNewPassword;
    private String customerRegisteredDate;

}
