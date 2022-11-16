package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
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
