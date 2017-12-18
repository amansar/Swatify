package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Rating;
import edu.swarthmore.cs.cs71.swatify.models.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingsControllerTest {
    public static final User user = new User("username", "accessToken", "refreshToken");

    @Test
    public void createNewRating() {
        Rating rating = new Rating(user, 5, "1");

        assertTrue(RatingsController.createRating(rating));
    }

    @Test
    public void getRating() {
        Rating rating = new Rating(user, 4, "3");

        assertTrue(RatingsController.createRating(rating));
        int id = rating.getId();

        Rating retrieveRating = RatingsController.getRating(id);
        assertEquals(4, retrieveRating.getStars());
    }

    @Test
    public void updateRating() {
        Rating rating = new Rating(user, 3, "10");

        assertTrue(RatingsController.createRating(rating));
        int id = rating.getId();
        rating.setStars(2);

        assertTrue(RatingsController.updateRating(rating));
        Rating updatedRating = RatingsController.getRating(id);
        assertEquals(2, updatedRating.getStars());
    }

    @Test
    public void deleteRating() {
        Rating rating = new Rating(user, 4, "4");

        assertTrue(RatingsController.createRating(rating));
        int id = rating.getId();

        assertTrue(RatingsController.deleteRating(id));
        assertNull(RatingsController.getRating(id));
    }
}
