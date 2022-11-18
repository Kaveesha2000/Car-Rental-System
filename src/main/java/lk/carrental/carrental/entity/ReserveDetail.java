package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@IdClass(ReserveDetails_PK.class)
public class ReserveDetail  {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String reserveId;
    @Id
    private String carId;
    @Id
    private String driverId;

    @Size(min = 3, max = 10,message = "Please try again")
    private String type;
    @Size(min = 3, max = 10,message = "Please try again")
    private String colour;
    @Size(min = 3, max = 10,message = "Please try again")
    private String brand;
    @Size(min = 3, max = 40,message = "Please try again")
    private String driverName;
    @Size(min = 3, max = 10,message = "Please try again")
    private double lossDamageWaiverPayment;

    @ManyToOne
    @JoinColumn(name = "reserveId",referencedColumnName = "reserveId",updatable = false,insertable = false)
    private Reserve reserve;

    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverId",referencedColumnName = "driverId",insertable = false,updatable = false)
    private Driver driver;
}
