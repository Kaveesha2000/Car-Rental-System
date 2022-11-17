package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Admin {
    @Id
    private String adminId;
    @Size(min = 3, max = 40,message = "Please enter the user name correctly")
    private String userName;
    @Size(min = 6, max = 40,message = "Please try to enter a strong password")
    private String adminPassword;
}
