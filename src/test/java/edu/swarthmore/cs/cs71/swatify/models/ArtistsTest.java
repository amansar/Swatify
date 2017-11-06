package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArtistsTest {

    @Test
    public void createArtist() throws Exception {
        Artist tribeCalledQuest = new Artist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        Assert.assertEquals("A Tribe Called Quest", tribeCalledQuest.getName());
        Assert.assertEquals("09hVIj6vWgoCDtT03h8ZCa", tribeCalledQuest.getSpotifyId());
    }
}
