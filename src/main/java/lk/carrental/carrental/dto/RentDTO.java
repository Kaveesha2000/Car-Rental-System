package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDTO {
    private String paymentId;
    private double rentFee;
    private double extraKm;
    private double extraKmFee;
    private double driverFee;
    private double fullPayment;
    private String rentDate;
    private double reducedLossDamagedWaiverPayment;
    private double lossDamagedWaiverPayment;
}
