package lk.ijse.carrent.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class RentEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "per_Day_Rent", nullable = false)
    private Double perDayRent;
    @Column(name = "from_Date", columnDefinition = "Date", nullable = false)
    private Date fromDate;
    @Column(name = "to_Date", columnDefinition = "Date", nullable = false)
    private Date toDate;
    @Column(name = "advance_dpay", nullable = false)
    private Double advancedPay;
    @Column(name = "refundable_Deposit", nullable = false)
    private Double refundableDeposit;
    @Column(name = "return_Date", columnDefinition = "Date", nullable = false)
    private Date retunDate;
    @Column(name = "total")
    private Double total;
    @Column(name = "balance")
    private Double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id", nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity carEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;



}
