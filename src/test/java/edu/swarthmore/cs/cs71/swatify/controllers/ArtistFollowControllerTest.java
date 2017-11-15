package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.models.ArtistFollow;
import edu.swarthmore.cs.cs71.swatify.models.User;
import org.junit.Assert;
import org.junit.Test;

public class ArtistFollowControllerTest {
    @Test
    public void shouldCreateFollow() throws Exception {
        User cameron = new User();
        Artist zachPalmer = new Artist();

        ArtistFollow cameronFollowZachPalmer = new ArtistFollow(cameron, zachPalmer);

        boolean success = ArtistFollowController.saveArtistFollow(cameronFollowZachPalmer);

        Assert.assertTrue(success);
    }

    @Test
    public void shouldGetFollow() throws Exception {
        User oliver = new User();
        Artist theStrokes = new Artist();

        ArtistFollow oliverFollowsTheStrokes = new ArtistFollow(oliver, theStrokes);
        ArtistFollowController.saveArtistFollow(oliverFollowsTheStrokes);

        int followId = oliverFollowsTheStrokes.getId();

        ArtistFollow returnedArtistFollow = ArtistFollowController.getArtistFollow(followId);

        Assert.assertEquals(oliverFollowsTheStrokes, returnedArtistFollow);
    }
}
