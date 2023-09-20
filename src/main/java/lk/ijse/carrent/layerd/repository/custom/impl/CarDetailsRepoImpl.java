package lk.ijse.carrent.layerd.repository.custom.impl;

import lk.ijse.carrent.layerd.entity.CarEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.CarDetailsRepo;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsRepoImpl implements CarDetailsRepo {

    @Override
    public Integer add(CarEntity carEntity) throws Exception {
        return null;
    }

    @Override
    public CarEntity get(String s) throws Exception {
        return null;
    }

    @Override
    public List<CarEntity> getAll() throws Exception {
       List<Object>  t = new CrudUtil().getAll("FROM CarEntity");
       List<CarEntity> carEntities = new ArrayList<>();
        for (Object type:t
             ) {
            CarEntity carEntity = (CarEntity) type;
            carEntities.add(carEntity);

        }
        return null;
    }

    @Override
    public Integer update(CarEntity carEntity) throws Exception {
        return null;
    }

    @Override
    public Integer delete(String s) throws Exception {
        return null;
    }
}
