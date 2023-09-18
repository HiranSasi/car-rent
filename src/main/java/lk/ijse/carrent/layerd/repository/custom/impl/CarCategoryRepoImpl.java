package lk.ijse.carrent.layerd.repository.custom.impl;

import lk.ijse.carrent.layerd.entity.CarCategoryEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.CarCategoryRepo;

public class CarCategoryRepoImpl implements CarCategoryRepo {
    @Override
    public Integer add(CarCategoryEntity carCategoryEntity) throws Exception {
       return new CrudUtil().add(carCategoryEntity);
    }

    @Override
    public CarCategoryEntity get(String s) throws Exception {
        return null;
    }
}
