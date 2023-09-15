package lk.ijse.carrent.layerd.repository;

import javafx.scene.control.Alert;
import lk.ijse.carrent.layerd.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrudUtil {


    Session session = SessionFactoryConfiguration.getInstance().getSession();
    public  Integer add(Object object){

        Transaction transaction =session.beginTransaction();
        Integer id;

        try {
            session.save(object);
            transaction.commit();
            return id = 10;

        }catch (Exception e){


            transaction.rollback();
            return -1;
        }
    }
}
