package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Schedule {
    @Id
    private String scheduleId;

    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String releasedOrNot;

    @OneToOne(cascade = CascadeType.ALL)
    private ReserveDetail reserveDetails;

}
