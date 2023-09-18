package lk.ijse.carrent.layerd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data




public class UserEntity {
    @Id

    @Column(name = "id")

    private String id;

    @Column(name = "user_name", nullable = false, length = 100, unique = true)

    private String userName;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public UserEntity(String id) {
        this.id = id;
    }

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false, unique = true, length = 100)
    private String password;

    @OneToMany(mappedBy = "userEntity", targetEntity = CarCategoryEntity.class)
    private List<CarCategoryEntity> carCategoryEntities;

   @OneToMany(mappedBy = "userEntity", targetEntity = CarEntity.class)
    private List<CarEntity> carEntities;

    @OneToMany(mappedBy = "userEntity", targetEntity = RentEntity.class)
    private List<RentEntity> rentEntities;

    @OneToMany(mappedBy = "userEntity", targetEntity = CustomerEntity.class)
    private List<CustomerEntity> customerEntities;


    public UserEntity(String id, String userName, String name, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
