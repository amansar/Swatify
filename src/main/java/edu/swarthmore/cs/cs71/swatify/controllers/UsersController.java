package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import static spark.Spark.*;

public class UsersController {
    public UsersController() {
        path("/users", () -> {
            get("/:id", (request, response) -> {
                int id = Integer.parseInt(request.params("id"));
                return HibernateUtil.getObjectById(User.class, id);
            }, GsonUtil::toJson);

            post("", (request, response) -> {
                User user = GsonUtil.fromJson(User.class, request.body());
                return HibernateUtil.saveObject(user);
            }, GsonUtil::toJson);

            patch("/:id", (request, response) -> {
                User user = GsonUtil.fromJson(User.class, request.body());
                return HibernateUtil.updateObject(user);
            }, GsonUtil::toJson);

            delete("/:id", (request, response) -> {
                int userId = Integer.parseInt(request.params("id"));
                return HibernateUtil.deleteObject(User.class, userId);
            }, GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });

        });
    }
}
