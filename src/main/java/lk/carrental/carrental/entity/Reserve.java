package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String reserveId;
    @Size(min = 10, max = 10,message = "Please try again")
    private String bookingDate;
    @Size(min = 10, max = 10,message = "Please try again")
    private String pickedDate;
    @Size(min = 6, max = 6,message = "Please try again")
    private String pickedTime;
    @Size(min = 10, max = 10,message = "Please try again")
    private String returnDate;
    @Size(min = 6, max = 6,message = "Please try again")
    private String returnTime;
    @Size(min = 3, max = 20,message = "Please try again")
    private String destination;
    @Size(min = 3, max = 4,message = "Please try again")
    private boolean driverWantOrNot;
    @Size(min = 4, max = 6,message = "Please try again")
    private String acceptOrDeny;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customer_Id", referencedColumnName = "customer_Id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "reserve",cascade = CascadeType.ALL)
    private List<ReserveDetail> reserveDetail;
}
