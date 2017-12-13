package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import edu.swarthmore.cs.cs71.swatify.errors.ForbiddenError;
import edu.swarthmore.cs.cs71.swatify.errors.InternalServerError;
import edu.swarthmore.cs.cs71.swatify.errors.NotFoundError;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import spark.Request;
import spark.Response;
import spark.Route;
import sun.jvm.hotspot.utilities.Interval;

public abstract class BaseRoute implements Route {

    @Override
    public String handle(Request request, Response response) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Object obj;
        try {
            obj = doAction(session, request, response);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            obj = new InternalServerError(e.getMessage());
        }
        finally {
            session.close();
        }
        return GsonUtil.toJson(obj);
    }

    protected abstract Object doAction(Session session, Request request, Response response);
}
