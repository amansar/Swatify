package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("oliver");
        user.setEmail("onewman1@swarthmore.edu");

        session.save(user);
        session.getTransaction().commit();

        session.close();
    }
}
