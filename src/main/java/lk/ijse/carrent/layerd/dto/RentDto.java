package lk.ijse.carrent.layerd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class RentDto {
    private String id;

    private Double perDayRent;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Double advancedPay;

    private Double refundableDeposit;

    private LocalDate retunDate;

    private Double total;

    private Double balance;

    private String userName;

    private String custId;

    private String carId;

    public RentDto(String id, Double perDayRent, LocalDate fromDate, LocalDate toDate, Double advancedPay, Double refundableDeposit, String userName, String custId, String carId) {
        this.id = id;
        this.perDayRent = perDayRent;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.advancedPay = advancedPay;
        this.refundableDeposit = refundableDeposit;
        this.userName = userName;
        this.custId = custId;
        this.carId = carId;
    }
}
