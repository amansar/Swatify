package edu.swarthmore.cs.cs71.swatify.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    /**
     * Save an object to the database.
     * @param object The object to persist.
     */
    public static void saveObject(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(object);
        session.getTransaction().commit();

        session.close();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
