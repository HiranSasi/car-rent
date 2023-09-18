package lk.ijse.carrent.layerd.repository;

import javafx.scene.control.Alert;
import lk.ijse.carrent.layerd.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CrudUtil {


    Session session = SessionFactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();

    public Integer add(Object object) {


        Integer id;

        try {
            session.save(object);
            transaction.commit();
            return id = 10;

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();


            transaction.rollback();
            return -1;
        }
    }

    public Object get(String hql){


        Query query = session.createQuery(hql);
         Object t =  query.uniqueResult();
         return t;


    }
}
