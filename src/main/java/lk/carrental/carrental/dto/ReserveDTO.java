package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReserveDTO {
    private String reserveId;
    private String bookingDate;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String destination;
    private boolean driverWantOrNot;
    private String acceptOrDeny;
    private CustomerDTO customerDTO;
    List<ReserveDetailDTO> reserveDetailDTOList;
}
