package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReserveDetails_PK implements Serializable {
    @Id
    private String reserveId;
    @Id
    private String carId;
    @Id
    private String driverId;
}
