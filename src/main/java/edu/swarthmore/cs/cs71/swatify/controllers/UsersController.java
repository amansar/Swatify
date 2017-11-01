package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

public class UsersController {
    public static User getUser(Request request, Response response) {
        int userId = Integer.parseInt(request.params("id"));
        return HibernateUtil.getObjectById(User.class, userId);
    }

    public static User createUser(Request request, Response response) {
        return new User("","");
    }

    public static User updateUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return new User("","");
    }

    public static User deleteUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return new User("","");
    }
}
