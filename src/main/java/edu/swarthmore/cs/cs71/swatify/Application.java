package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.*;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        externalStaticFileLocation("src/main/resources/build");

        establishRoutes();
    }

    public static void establishRoutes() {
        path("/api/v1", () -> {
            new UsersController();
            new SessionsController();
            new ArtistsController();
            new AlbumsController();
            new DiscussionsController();
            new PostsController();

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }
}
