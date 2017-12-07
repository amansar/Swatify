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
            path("/:id", () -> {
                before(((request, response) -> {
                    if (request.session().attribute("userId") != request.params("id")) {
                        halt(401, GsonUtil.toJson(new UnauthorizedError("You must log in to view this page.")));
                    }
                }));

                get("", (request, response) -> new GetObjectRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
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
