package lk.ijse.carrent.layerd.repository.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.carrent.layerd.entity.CarEntity;
import lk.ijse.carrent.layerd.entity.RentEntity;
import lk.ijse.carrent.layerd.repository.CrudUtil;
import lk.ijse.carrent.layerd.repository.custom.RentRepo;
import lk.ijse.carrent.layerd.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RentRepoImpl implements RentRepo {
    @Override
    public Integer add(RentEntity rentEntity) throws Exception {
        return new CrudUtil().add(rentEntity);
    }

    @Override
    public RentEntity get(String s) throws Exception {
        return (RentEntity) new CrudUtil().get("FROM RentEntity WHERE id = '" + s + "'");
    }

    @Override
    public List<RentEntity> getAll() throws Exception {
        List<Object>  t = new CrudUtil().getAll("FROM RentEntity");
        List<RentEntity> rentEntities = new ArrayList<>();
        for (Object type:t

        ) {
            RentEntity rentEntity = (RentEntity) type;
            rentEntities.add(rentEntity);

        }
        return rentEntities;
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

    @Override
    public Integer updateReturnDate(RentEntity rent) throws Exception {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Integer id = -1;

        Transaction transaction = session.getTransaction();


        String hql = "UPDATE RentEntity SET balance = :balance , total = :total ,retunDate = :return WHERE id = :rentId";
        try {
            transaction.begin();

            Query query = session.createQuery(hql);
            query.setParameter("balance",rent.getBalance());
            query.setParameter("total",rent.getTotal());
            query.setParameter("return",rent.getRetunDate());
            query.setParameter("rentId",rent.getId());

            Integer update = query.executeUpdate();

            transaction.commit();

            return id = 10;


        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return id;
        }


    }
}
