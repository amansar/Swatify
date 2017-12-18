package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Followers;
import com.wrapper.spotify.models.SimpleAlbum;
import edu.swarthmore.cs.cs71.swatify.models.SwatifyArtist;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArtistsControllerTest {

//    @Test
//    public void shouldCreateNewArtistInDatabase() throws Exception {
//        SwatifyArtist cameron = new SwatifyArtist();
//        cameron.setName("Cameron");
//        cameron.setSpotifyId(null);
//
//        assertTrue(ArtistsController.createArtist(cameron));
//    }
//
//    @Test
//    public void shouldGetExistingArtistFromDatabase() throws Exception {
//        SwatifyArtist zach = new SwatifyArtist();
//        zach.setName("Zachariah");
//        zach.setSpotifyId("ljh46kjh436jbnk6j2bk2624");
//
//        HibernateUtil.saveObject(zach);
//
//        int id = zach.getId();
//
//        SwatifyArtist existingSwatifyArtist = HibernateUtil.getObjectById(SwatifyArtist.class, id);
//
//        Assert.assertEquals(zach.getName(), existingSwatifyArtist.getName());
//        Assert.assertEquals(zach.getSpotifyId(), existingSwatifyArtist.getSpotifyId());
//        Assert.assertEquals(id, existingSwatifyArtist.getId());
//    }

    @Test
    public void shouldGetArtistInfoFromSpotify() throws Exception {
        SwatifyArtist knxwledge = new SwatifyArtist("Knxwledge", "17Zu03OgBVxgLxWmRUyNOJ");
        Artist spotifyArtist = ArtistsController.getArtist(knxwledge.getSpotifyId());

        Assert.assertEquals("Knxwledge", spotifyArtist.getName());
        Assert.assertEquals("17Zu03OgBVxgLxWmRUyNOJ", spotifyArtist.getId());

        System.out.printf("%s -- %s music\n", spotifyArtist.getName(), spotifyArtist.getGenres());
        System.out.printf("%d followers\n", spotifyArtist.getFollowers().getTotal());
        System.out.println("Albums:");
        for(SimpleAlbum album : ArtistsController.getArtistAlbums(knxwledge.getSpotifyId())){
            System.out.println("    " + album.getName());
        }

    }
    
    @Test
    public void shouldGetArtistFollowers() {
        Artist knxwledge = ArtistsController.getArtist("17Zu03OgBVxgLxWmRUyNOJ");
        Followers knxwledgeFollowers = ArtistsController.getArtistFollowers("17Zu03OgBVxgLxWmRUyNOJ");

        assertEquals(knxwledge.getFollowers().getTotal(), knxwledgeFollowers.getTotal());
    }

}
