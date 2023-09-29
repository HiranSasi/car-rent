package lk.ijse.carrent.layerd.repository.custom.impl;

import lk.ijse.carrent.layerd.entity.RentEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.RentRepo;

import java.util.List;

public class RentRepoImpl implements RentRepo {
    @Override
    public Integer add(RentEntity rentEntity) throws Exception {
        return new CrudUtil().add(rentEntity);
    }

    @Override
    public RentEntity get(String s) throws Exception {
        return null;
    }

    @Override
    public List<RentEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public Integer update(RentEntity rentEntity) throws Exception {
        return null;
    }

    @Override
    public Integer delete(String s) throws Exception {
        return null;
    }

    @Override
    public Integer save(RentEntity rentEntity) throws Exception {
        return null;
    }
}
