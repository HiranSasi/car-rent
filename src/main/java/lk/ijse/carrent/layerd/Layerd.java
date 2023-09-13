package lk.ijse.carrent.layerd;

import lk.ijse.carrent.layerd.util.SessionFactoryConfiguration;
import org.hibernate.Session;

public class Layerd {

    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        System.out.println("helo status");
    }
}
