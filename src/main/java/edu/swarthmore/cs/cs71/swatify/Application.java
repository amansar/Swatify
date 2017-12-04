package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.*;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        externalStaticFileLocation("src/main/resources/build");

        setRoutes();
    }

    public static void setRoutes() {
        path("/api/v1", () -> {
            new UsersController();
            new ArtistsController();
            new AlbumsController();
            new DiscussionsController();
            new RatingsController();
        });
    }
}
