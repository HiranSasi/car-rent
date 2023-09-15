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

    @Column(name = "name", length = 55, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "carCategoryEntity", targetEntity = CarEntity.class)
    private List<CarEntity> carEntities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
}
