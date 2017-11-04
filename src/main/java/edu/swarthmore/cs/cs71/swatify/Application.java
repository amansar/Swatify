package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController;
import edu.swarthmore.cs.cs71.swatify.controllers.UsersController;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        setRoutes();

        User user = new User();
        user.setEmail("oliver@whmsi.com");
        user.setUsername("oliver@whmsi.com");
        HibernateUtil.saveObject(user);
    }

    private static void setRoutes() {
        path("/api/v1", () -> {
            new UsersController();
            new ArtistsController();
        });
    }
}
