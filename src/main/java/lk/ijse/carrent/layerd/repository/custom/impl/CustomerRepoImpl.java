package lk.ijse.carrent.layerd.repository.custom.impl;

import lk.ijse.carrent.layerd.entity.CarCategoryEntity;
import lk.ijse.carrent.layerd.entity.CustomerEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.CustomerRepo;
import lk.ijse.carrent.layerd.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CustomerRepoImpl implements CustomerRepo {
    @Override
    public Integer add(CustomerEntity customerEntity) throws Exception {
        return new CrudUtil().add(customerEntity);
    }

    @Override
    public CustomerEntity get(String s) throws Exception {
        return (CustomerEntity) new CrudUtil().get("FROM CustomerEntity WHERE id = '" + s + "'");
    }

    @Override
    public List<CustomerEntity> getAll() throws Exception {
        List<Object> t = new CrudUtil().getAll("FROM CustomerEntity");
        List<CustomerEntity>customerEntities = new ArrayList<>();

        for (Object type:t)
        {
            CustomerEntity entity = (CustomerEntity) type;
            customerEntities.add(entity);


        }

        return customerEntities;
    }

    @Override
    public Integer update(CustomerEntity customerEntity) throws Exception {
        return new CrudUtil().update(customerEntity);
    }

    @Override
    public Integer delete(String s) throws Exception {
        System.out.println("hhh==="+s);
        return new CrudUtil().delete("DELETE FROM CustomerEntity WHERE id = '"+ s +"'");
    }

    @Override
    public Integer save(CustomerEntity customerEntity) throws Exception {
        return null;
    }


    @Override
    public Integer addMobile(CustomerEntity customerEntity) throws Exception {
        return null;
    }
}