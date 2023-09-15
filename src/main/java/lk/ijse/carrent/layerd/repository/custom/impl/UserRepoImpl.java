package lk.ijse.carrent.layerd.repository.custom.impl;

import lk.ijse.carrent.layerd.entity.UserEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.UserRepo;

public class UserRepoImpl implements UserRepo {


    @Override
    public Integer add(UserEntity t) throws Exception {

       return new CrudUtil().add(t);
    }
}
