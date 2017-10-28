package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.UsersController;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        setRoutes();
    }

    private static void setRoutes() {
        path("/api/v1", () -> {
            path("/users", () -> {
                get("/*", (request, response) -> UsersController.getUser(request, response));
                put("/*", (request, response) -> UsersController.createUser(request, response));
                patch("/*", (request, response) -> UsersController.updateUser(request, response));
                delete("/*", (request, response) -> UsersController.deleteUser(request, response));
            });
        });
    }
}
