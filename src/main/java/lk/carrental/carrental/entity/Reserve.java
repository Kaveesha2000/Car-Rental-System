package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Reserve {
    @Id
    private String reserveId;
    private String bookingDate;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String destination;
    private boolean driverWantOrNot;
    private String acceptOrDeny;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "reserve",cascade = CascadeType.ALL)
    private List<ReserveDetail> reserveDetail;
}
