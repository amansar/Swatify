package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import spark.Request;
import spark.Response;

public abstract class UpdateObjectRoute extends BaseRoute {
    @Override
    protected Object doAction(Request request, Response response) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Object obj = createUpdatedObject(request, response);
        session.update(obj);
        return obj;
    }

    protected abstract Object createUpdatedObject(Request request, Response response);
}
