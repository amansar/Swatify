package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArtistsControllerTest {

    @Test
    public void shouldCreateNewArtist() throws Exception {
        Artist cameron = new Artist();
        cameron.setName("Cameron");
        cameron.setSpotifyId(null);

        assertTrue(ArtistsController.createArtist(cameron));
    }

    @Test
    public void shouldGetExistingArtist() throws Exception {
        Artist zach = new Artist();
        zach.setName("Zachariah");
        zach.setSpotifyId("ljh46kjh436jbnk6j2bk2624");

        HibernateUtil.saveObject(zach);

        int id = zach.getId();

        Artist existingArtist = HibernateUtil.getObjectById(Artist.class, id);

        Assert.assertEquals(zach.getName(), existingArtist.getName());
        Assert.assertEquals(zach.getSpotifyId(), existingArtist.getSpotifyId());
        Assert.assertEquals(id, existingArtist.getId());
    }
}
