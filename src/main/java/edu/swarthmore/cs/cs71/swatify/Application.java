package edu.swarthmore.cs.cs71.swatify;

import com.github.javafaker.Faker;
import edu.swarthmore.cs.cs71.swatify.controllers.AlbumsController;
import edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController;
import edu.swarthmore.cs.cs71.swatify.controllers.UsersController;
import edu.swarthmore.cs.cs71.swatify.models.User;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
//        setRoutes();

        staticFiles.location("/public");

        User user = new User("oliver", "onewman1@swarthmore.edu", "asdfsadf");
        UsersController.createUser(user);

        Faker faker;
        for (int i = 0; i < 50; i++) {
            faker = new Faker();
            user = new User(faker.name().username(), faker.internet().emailAddress(), faker.crypto().sha256());
            UsersController.createUser(user);
            System.out.println(user.getId());
        }
    }

    public static void setRoutes() {
        path("/api/v1", () -> {
            new UsersController();
            new ArtistsController();
            new AlbumsController();
        });
    }
}
