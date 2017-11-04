package edu.swarthmore.cs.cs71.swatify.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaQuery;
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

    /**
     * Update an object in the database.
     * @param object The updated object to save to the database.
     */
    public static void updateObject(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Retrieve all the objects of a specified class from the database.
     * @param objectClass The class of the objects to retrieve.
     * @param <T> The class of the objects.
     * @return A list of all objects of the specified class.
     */
    public static <T> List<T> listObjects(Class<T> objectClass) {
        Session session = sessionFactory.openSession();
        CriteriaQuery<T> cq = session.getCriteriaBuilder().createQuery(objectClass);
        cq.from(objectClass);
        List<T> objectList = session.createQuery(cq).getResultList();
        session.close();

        return objectList;
    }
}
