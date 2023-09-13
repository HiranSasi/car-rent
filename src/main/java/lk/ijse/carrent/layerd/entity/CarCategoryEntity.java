package lk.ijse.carrent.layerd.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CarCategoryEntity {

    @Id
    @Column(name = "id")
   private String id;

    @Column(name = "name", length = 55, nullable = false)
   private String name;

    @OneToMany(mappedBy = "carCategoryEntity",targetEntity = CarEntity.class)
    private List<CarEntity>carEntities;
}
