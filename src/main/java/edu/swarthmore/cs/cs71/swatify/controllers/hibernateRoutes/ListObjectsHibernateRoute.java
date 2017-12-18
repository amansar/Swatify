package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import org.hibernate.Session;
import spark.Request;
import spark.Response;

import javax.persistence.criteria.CriteriaBuilder;

public abstract class ListObjectsRoute extends BaseRoute {
    @Override
    public Object doAction(Session session, Request request, Response response) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        return criteriaBuilder.createQuery(getObjectClass()).getOrderList();
    }

    protected abstract Class<?> getObjectClass();
}
