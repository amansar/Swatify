package edu.swarthmore.cs.cs71.swatify.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

    /**
     * Retrieve an object from the database.
     * @param objectClass The class of the object to retrieve.
     * @param objectId The ID of the object to retrieve.
     * @param <T> The class of the object.
     * @return The desired object, or null if the object doesn't exist.
     */
    public static <T> T getObjectById(Class<T> objectClass, int objectId) {
        Session session = sessionFactory.openSession();
        Object object = session.get(objectClass, objectId);
        session.close();

        return objectClass.cast(object);
    }

    public static <T> T updateObject(Class<T> objectClass, int objectId) {
        Session session = sessionFactory.openSession();
        Object object = session.get(objectClass, objectId);
        session.close();

        return objectClass.cast(object);
    }

    public static <T> List<T> listObjects(Class<T> objectClass) {
        return new List();
    }
}
