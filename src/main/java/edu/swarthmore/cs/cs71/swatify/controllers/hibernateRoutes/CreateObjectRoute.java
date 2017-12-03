package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import spark.Request;
import spark.Response;

public abstract class CreateObjectRoute extends BaseRoute  {
    @Override
    public Object doAction(Request request, Response response) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Object obj = createObject(request, response);
        session.save(obj);
        return obj;
    }

    protected abstract Object createObject(Request request, Response response);
}
