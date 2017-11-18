import model.Orders;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utility.HibernateUtility;

import java.time.LocalDate;

/**
 * Created by HP on 2017-11-18.
 */
public class Main {

    public static void main(String[] args) {


        Session session = HibernateUtility.getHibernateSession();

        User user1 = new User();
        user1.setUserName("Franek");
        user1.setAdres("Bydgoszcz");

        User user2 = new User();
        user2.setUserName("Janina");
        user2.setAdres("Torun");

        Orders order1 = new Orders();
        order1.setThingList("Car");
        order1.setOrdersDate(LocalDate.parse("2017-01-01"));

        Orders order2 = new Orders();
        order1.setThingList("Book");
        order2.setOrdersDate(LocalDate.parse("2017-02-02"));

        order1.toString();
//zaczynam transakcje
        session.beginTransaction();

        session.save(user1);
        session.save(user2);

        order1.setUser(user1);
        order2.setUser(user1);

        session.save(order1);
        session.save(order2);
        session.getTransaction().commit();
        session.close();
        HibernateUtility.closeSession();


    }
}
