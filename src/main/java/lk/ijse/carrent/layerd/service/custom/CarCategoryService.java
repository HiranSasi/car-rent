package lk.ijse.carrent.layerd.service.custom;

import lk.ijse.carrent.layerd.dto.CarCategoryDto;
import lk.ijse.carrent.layerd.service.SuperService;

import java.util.List;

public interface CarCategoryService extends SuperService {

    String addCarCategory(CarCategoryDto carCategoryDto) throws Exception;
    List<CarCategoryDto> getAll()throws Exception;
}
