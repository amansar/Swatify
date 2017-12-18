package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.DeleteObjectHibernateRoute;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.GetObjectHibernateRoute;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.UpdateObjectHibernateRoute;
import edu.swarthmore.cs.cs71.swatify.errors.UnauthorizedError;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class UsersController {
    public UsersController() {
        path("/users", () -> {
            before((request, response) -> {
                User user = request.session().attribute("user");
                if (user == null) {
                    throw halt(401, "Log in with Spotify");
                }
            });

            get("/me", (request, response) -> {
                User user = request.session().attribute("user");
                if (user == null) {
                    return GsonUtil.toJson(new UnauthorizedError("Log in with Spotify"));
                }
                return GsonUtil.toJson(user);
            });

            path("/:id", () -> {
                get("", (request, response) -> new GetObjectHibernateRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
                        System.out.println("asdf");
                        return User.class;
                    }
                });

                put("", (request, response) -> new UpdateObjectHibernateRoute() {
                    @Override
                    protected Object createUpdatedObject(Request request, Response response) {
                        return GsonUtil.fromJson(User.class, request.body());
                    }
                });

                // Delete a user.
                delete("", (request, response) -> new DeleteObjectHibernateRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
                        return User.class;
                    }
                });
            });
        });
    }
}
