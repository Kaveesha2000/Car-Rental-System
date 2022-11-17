package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Schedule {
    @Id
    private String scheduleId;

    @Size(min = 10, max = 10,message = "Please try again")
    private String pickedDate;
    @Size(min = 6, max = 6,message = "Please try again")
    private String pickedTime;
    @Size(min = 10, max = 10,message = "Please try again")
    private String returnDate;
    @Size(min = 3, max = 7,message = "Please try again")
    private String releasedOrNot;

    @OneToOne(cascade = CascadeType.ALL)
    private ReserveDetail reserveDetails;

}
