package lk.ijse.carrent.layerd.service.custom;

import lk.ijse.carrent.layerd.dto.CarCategoryDto;
import lk.ijse.carrent.layerd.service.SuperService;

public interface CarCategoryService extends SuperService {

    String addCarCategory(CarCategoryDto carCategoryDto) throws Exception;
}
