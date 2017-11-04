package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController;
import edu.swarthmore.cs.cs71.swatify.controllers.UsersController;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        setRoutes();
    }

    private static void setRoutes() {
        path("/api/v1", () -> {
            new UsersController();
            new ArtistsController();
        });
    }
}
