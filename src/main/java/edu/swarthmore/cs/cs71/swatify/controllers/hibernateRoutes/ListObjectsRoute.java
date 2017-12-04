package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import spark.Request;
import spark.Response;

import java.util.List;

public abstract class ListObjectsRoute extends BaseRoute {
    @Override
    public Object doAction(Session session, Request request, Response response) {
        Class<?> cls = getObjectClass();
        String queryString = String.format("SELECT * FROM %s", cls.getName());
        List<?> objectList = session.createQuery(queryString, cls).getResultList();
        return objectList;
    }

    protected abstract Class<?> getObjectClass();
}
