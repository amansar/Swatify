package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.models.Rating;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RatingsControllerTest {
    @Test
    public void createNewRating() {
        Rating rating = new Rating(1, 5, "1");

        assertTrue(RatingsController.createRating(rating));
    }

    @Test
    public void getRating() {
        Rating rating = new Rating(2, 4, "3");

        assertTrue(RatingsController.createRating(rating));
        int id = rating.getId();

        Rating retrieveRating = RatingsController.getRating(id);
        assertEquals(4, retrieveRating.getStars());
    }

    @Test
    public void updateRating() {
        Rating rating = new Rating(3, 3, "10");

        assertTrue(RatingsController.createRating(rating));
        int id = rating.getId();
        rating.setStars(2);

        assertTrue(RatingsController.updateRating(rating));
        Rating updatedRating = RatingsController.getRating(id);
        assertEquals(2, updatedRating.getStars());
    }

    @Test
    public void deleteRating() {
        Rating rating = new Rating(4, 4, "4");

        assertTrue(RatingsController.createRating(rating));
        int id = rating.getId();

        assertTrue(RatingsController.deleteRating(id));
        assertNull(RatingsController.getRating(id));
    }
}
