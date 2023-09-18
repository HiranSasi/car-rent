package lk.ijse.carrent.layerd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CarCategoryDto {

    private String id;
    private String name;

    public CarCategoryDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private  String userid;
}
