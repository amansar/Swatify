package edu.swarthmore.cs.cs71.swatify.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Source: http://fruzenshtein.com/hibernate-mysql-maven-tutorial/

public class HibernateUtil {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
