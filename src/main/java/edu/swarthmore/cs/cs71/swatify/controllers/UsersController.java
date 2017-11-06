package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class UsersController {
    public UsersController() {
        path("/users", () -> {
            get("/:id", this::getUser, GsonUtil::toJson);
            post("", this::createUser, GsonUtil::toJson);
            patch("/:id", this::updateUser, GsonUtil::toJson);
            delete("/:id", this::deleteUser, GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });

        });
    }

    User getUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return HibernateUtil.getObjectById(User.class, id);
    }

    User createUser(Request request, Response response) {
        User user = GsonUtil.fromJson(User.class, request.body());
        return HibernateUtil.saveObject(user);
    }

    User updateUser(Request request, Response response) {
        User user = GsonUtil.fromJson(User.class, request.body());
        return HibernateUtil.updateObject(user);
    }

    User deleteUser(Request request, Response response) {
        int userId = Integer.parseInt(request.params("id"));
        return HibernateUtil.deleteObject(User.class, userId);
    }

}
