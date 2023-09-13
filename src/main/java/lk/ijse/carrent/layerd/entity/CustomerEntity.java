package lk.ijse.carrent.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nic", length = 15, nullable = false)
    private Integer nic;
    @Column(name = "name", length = 55, nullable = false)
    private String name;
    @Column(name = "address", length = 100, nullable = false)
    private String Address;
    @ElementCollection
    @CollectionTable(
            name = "customer_mobile",

            joinColumns = @JoinColumn(name = "customer_id")
    )
    private List<String> mobil;

    @OneToMany(mappedBy = "customerEntity",targetEntity = RentEntity.class)

    private List<RentEntity>rentEntities;


}
