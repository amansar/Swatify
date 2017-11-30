package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.errors.ForbiddenError;
import edu.swarthmore.cs.cs71.swatify.errors.NotFoundError;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.Request;
import spark.Response;

import java.util.List;

public abstract class ControllerTemplate {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    /**
     * Save an object to the database.
     */
    public String createObject(Request request, Response response) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String jsonObject;
        try {
            jsonObject = GsonUtil.toJson(this.doCreateObject(request, response));
            session.getTransaction().commit();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            response.status(403);
            jsonObject = GsonUtil.toJson(new ForbiddenError("Cannot create object"));
        }
        finally {
            session.close();
        }
        return jsonObject;
    }

    abstract <T> T doCreateObject(Request request, Response response);

    /**
     * Retrieve an object from the database.
     */
    public String getObject(Request request, Response response) {
        Session session = sessionFactory.openSession();

        String jsonObject;
        try {
            jsonObject = GsonUtil.toJson(this.doGetObject(request, response));
        } catch (Exception e) {
            response.status(404);
            jsonObject = GsonUtil.toJson(new NotFoundError("Not found"));
        }
        finally {
            session.close();
        }
        return jsonObject;
    }

    abstract <T> T doGetObject(Request request, Response response);

    /**
     * Update an object in the database.
     */
    public String updateObject(Request request, Response response) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String jsonObject;

        try {
            jsonObject = GsonUtil.toJson(this.doUpdateObject(request, response));
            session.getTransaction().commit();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            jsonObject = GsonUtil.toJson(new NotFoundError("Not found"));
        }
        finally {
            session.close();
        }
        return jsonObject;
    }

    abstract <T> T doUpdateObject(Request request, Response response);

    /**
     * Delete an object in the database.
     */
    public String deleteObject(Request request, Response response) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            doDeleteObject(request, response);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            response.status(403); // Forbidden
        }
        finally {
            session.close();
        }
        return ""; // TODO
    }

    abstract void doDeleteObject(Request request, Response response);

    /**
     * Retrieve all the objects of a specified class from the database.
     */
    public String listObjects(Request request, Response response) {
    }

    abstract <T> List<T> doListObjects(Request request, Response response);
}
