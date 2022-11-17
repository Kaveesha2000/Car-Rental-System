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
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String paymentId;
    @Size(min = 6, max = 40,message = "Please try again")
    private double rentFee;
    @Size(min = 6, max = 40,message = "Please try to enter a strong password")
    private double extraKm;
    @Size(min = 1, max = 20,message = "Please try again")
    private double extraKmFee;
    @Size(min = 3, max = 10,message = "Please try again")
    private double driverFee;
    @Size(min = 3, max = 10,message = "Please try again")
    private double fullPayment;
    @Size(min = 10, max = 10,message = "Please try again")
    private String rentDate;
    @Size(min = 3, max = 10,message = "Please try again")
    private double reducedLossDamagedWaiverPayment;
    @Size(min = 3, max = 10,message = "Please try again")
    private double lossDamagedWaiverPayment;

}
