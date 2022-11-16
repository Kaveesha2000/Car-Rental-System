package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ScheduleDTO {
    private String scheduleId;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String releasedOrNot;

    private ReserveDetailDTO reserveDetails;
}
