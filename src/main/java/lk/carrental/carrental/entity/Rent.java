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
public class Rent {
    @Id
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
