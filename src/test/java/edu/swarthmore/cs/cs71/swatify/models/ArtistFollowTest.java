package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

public class ArtistFollowTest {

    @Test
    public void shouldCreateArtistFollow() throws Exception {
        SwatifyArtist tribeCalledQuest = new SwatifyArtist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        User cameron = new User();
        ArtistFollow cameronFollowsTribe = new ArtistFollow(cameron, tribeCalledQuest);

        Assert.assertEquals(cameron, cameronFollowsTribe.getFollower());
        Assert.assertEquals(tribeCalledQuest, cameronFollowsTribe.getSwatifyArtist());
    }


}
