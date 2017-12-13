package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.DeleteObjectRoute;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.GetObjectRoute;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.UpdateObjectRoute;
import edu.swarthmore.cs.cs71.swatify.errors.UnauthorizedError;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class UsersController {
    public UsersController() {
        path("/users", () -> {
            get("/me", (request, response) -> {
                User user = request.session().attribute("user");
                return user == null ? GsonUtil.toJson(user) : "{}";
            });

            path("/:id", () -> {
                get("", (request, response) -> new GetObjectRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
                        System.out.println("asdf");
                        return User.class;
                    }
                });

                put("", (request, response) -> new UpdateObjectRoute() {
                    @Override
                    protected Object createUpdatedObject(Request request, Response response) {
                        return GsonUtil.fromJson(User.class, request.body());
                    }
                });

                // Delete a user.
                delete("", (request, response) -> new DeleteObjectRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
                        return User.class;
                    }
                });
            });
        });
    }
}
