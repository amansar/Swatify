package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.AlbumsController;
import edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController;
import edu.swarthmore.cs.cs71.swatify.controllers.UsersController;
import edu.swarthmore.cs.cs71.swatify.models.Artist;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        setRoutes();
    }

    public static void setRoutes() {
        path("/api/v1", () -> {
            UsersController usersController = new UsersController();
            ArtistsController artistsController = new ArtistsController();
            AlbumsController albumsController = new AlbumsController();
        });
    }
}
