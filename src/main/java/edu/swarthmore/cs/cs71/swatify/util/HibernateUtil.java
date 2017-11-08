package edu.swarthmore.cs.cs71.swatify.util;

import org.hibernate.HibernateException;
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
     * @param <T> the class of the object.
     */
    public static <T> boolean saveObject(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        boolean saved = false;

        try {
            session.save(object);
            session.getTransaction().commit();
            saved = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return saved;
    }

    /**
     * Retrieve an object from the database.
     * @param objectClass The class of the object to retrieve.
     * @param objectId The ID of the object to retrieve.
     * @param <T> The class of the object.
     * @return The desired object, or null if the object doesn't exist.
     */
    public static <T> T getObjectById(Class<T> objectClass, int objectId) {
        T object;

        try (Session session = sessionFactory.openSession()) {
            object = session.get(objectClass, objectId);
        } catch (Exception e) {
            object = null;
        }

        return objectClass.cast(object);
    }

    /**
     * Update an object in the database.
     * @param object The updated object to save to the database.
     */
    public static <T> boolean updateObject(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        boolean updated = false;

        try {
            session.update(object);
            session.getTransaction().commit();
            updated = true;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            object = null;
        }
        finally {
            session.close();
        }

        return updated;
    }

    /**
     * Delete an object in the database.
     * @param objectClass The class of the object to delete.
     * @param objectId The ID of the object to delete.
     * @param <T> The class of the object.
     */
    public static <T> boolean deleteObject(Class<T> objectClass, int objectId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T object = null;

        boolean deleted = false;

        try {
            object = objectClass.cast(session.get(objectClass, objectId));
            session.delete(object);
            session.getTransaction().commit();
            deleted = true;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return deleted;
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
