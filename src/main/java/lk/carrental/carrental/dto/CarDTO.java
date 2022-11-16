package lk.carrental.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
    private String carId;
    private String registerNo;
    private String transmissionType;
    private String color;
    private String carType;
    private String brand;
    private String fuelType;
    private int noOfPassengers;
    private double wholeKm;
    private double extraOneKmFee;
    private double dailyRatePrice;
    private double monthlyRatePrice;
    private String availableOrNot;
    private String underMaintainanceOrNot;
    private String frontView;
    private String backView;
    private String sideView;
    private String interiorView;
}
