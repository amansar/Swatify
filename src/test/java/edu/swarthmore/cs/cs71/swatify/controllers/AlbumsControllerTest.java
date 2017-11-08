package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Album;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.swarthmore.cs.cs71.swatify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;


public class AlbumsControllerTest {

    @Test
    public void shouldCreateAndRetrieveCorrectAlbum(){
        Album collegeDropouts = new Album();
        collegeDropouts.setReleaseDate(new Timestamp(3L));
        collegeDropouts.setSpotifyID("843ghg48");
        collegeDropouts.setTitle("College Dropouts");

        assertTrue(AlbumsController.createAlbum(collegeDropouts));
    }

    @Test
    public void shouldGetExistingAlbum() throws Exception {
        Album  graduation= new Album();
        graduation.setTitle("graduation");
        graduation.setSpotifyID("7vhf8dbvh");

        HibernateUtil.saveObject(graduation);

        int id = graduation.getId();

        Album existingAlbum = HibernateUtil.getObjectById(Album.class, id);

        Assert.assertEquals(graduation.getTitle(), existingAlbum.getTitle());
        Assert.assertEquals(graduation.getSpotifyID(), existingAlbum.getSpotifyID());
        Assert.assertEquals(id, existingAlbum.getId());
    }

}
