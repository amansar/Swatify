package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

public class RatingsTest {
    @Test
    public void createRating() throws Exception {
        Rating newRating = new Rating(1, 5, 7);
        Assert.assertEquals(5, newRating.getStars());
        Assert.assertEquals(1, newRating.getUserId());
        Assert.assertEquals(7, newRating.getspotifyId());
        Assert.assertEquals(0, newRating.getId());
    }

    @Test
    public void changeStars() throws Exception {
        Rating newRating = new Rating(1, 3, 1);
        Assert.assertEquals(3, newRating.getStars());
        newRating.setStars(5);
        Assert.assertEquals(5, newRating.getStars());
    }
}
