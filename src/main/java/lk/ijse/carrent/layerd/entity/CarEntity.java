package lk.ijse.carrent.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Car")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CarEntity {

    @Id
    @Column(name = "car_id")

  private   String id;
    @Column(name = "brand",length = 55,nullable = false)
  private   String brand;
    @Column(name = "model",length = 55,nullable = false)
  private   String model;
    @Column(name = "year",length = 5,nullable = false)
   private Integer year;
    @Column(name = "vehicle_numb",length = 9,nullable = false)
  private   String vehicleNumber;
    @Column(name = "price_per_day",length = 10)
  private   Double pricePerDay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_cate_id",nullable = false)
    private CarCategoryEntity carCategoryEntity;
@OneToMany(mappedBy = "carEntity",targetEntity = RentEntity.class)
private List<RentEntity>rentEntities;
}
