package lk.ijse.carrent.layerd.repository.custom.impl;

import lk.ijse.carrent.layerd.entity.CarEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.CarDetailsRepo;
import lk.ijse.carrent.layerd.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsRepoImpl implements CarDetailsRepo {

    @Override
    public Integer add(CarEntity carEntity) throws Exception {
        return new CrudUtil().add(carEntity);
    }

    @Override
    public CarEntity get(String s) throws Exception {
        return (CarEntity) new CrudUtil().get("FROM CarEntity WHERE id = '" + s + "'");
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
        return carEntities;
    }

    @Override
    public Integer update(CarEntity carEntity) throws Exception {
        return new CrudUtil().update(carEntity);
    }

    @Override
    public Integer delete(String s) throws Exception {
        return new CrudUtil().delete("DELETE FROM CarEntity WHERE id = '"+ s +"'");
    }

    @Override
    public Integer save(CarEntity carEntity) throws Exception {





        return null;

    }

    }


