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
            before((request, response) -> {
                if (request.session().attribute("user") == null) {
                    halt(401, "Log in with Spotify");
                }
            });

            new UsersController();
            new SessionsController();
            new ArtistsController();
            new AlbumsController();
            new DiscussionsController();
            new PostsController();
            new RatingsController();

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }
}
