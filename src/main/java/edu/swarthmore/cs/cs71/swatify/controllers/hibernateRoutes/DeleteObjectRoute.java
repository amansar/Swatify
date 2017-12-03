package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import spark.Request;
import spark.Response;

public abstract class DeleteObjectRoute extends BaseRoute {

    @Override
    public Object doAction(Request request, Response response) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        int id = Integer.parseInt(request.params().get("id"));
        Object obj = session.load(getObjectClass(), id);
        session.delete(obj);
        return obj;
    }

    protected abstract Class<?> getObjectClass();
}