package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

public class SwatifyArtistsTest {

    @Test
    public void createArtist() throws Exception {
        SwatifyArtist tribeCalledQuest = new SwatifyArtist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        Assert.assertEquals("A Tribe Called Quest", tribeCalledQuest.getName());
        Assert.assertEquals("09hVIj6vWgoCDtT03h8ZCa", tribeCalledQuest.getSpotifyId());
    }
}
