package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

public class RatingsTest {
    @Test
    public void createRating() throws Exception {
        Rating newRating = new Rating(1, 5, 7);
        Assert.assertEquals(5, newRating.getStars());
        Assert.assertEquals(7, newRating.getSpotifyId());
        Assert.assertEquals(0, newRating.getId());
    }

    @Test
    public void changeStars() throws Exception {
    }
}
