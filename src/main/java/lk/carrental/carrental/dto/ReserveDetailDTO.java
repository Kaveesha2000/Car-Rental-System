package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReserveDetailDTO {
    private String reserveId;
    private String carId;
    private String driverId;
    private String type;
    private String colour;
    private String brand;
    private String driverName;
    private double lossDamageWaiverPayment;
}
