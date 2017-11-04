package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArtistTest {

    @Test
    public void createArtist() throws Exception {
        Artist tribeCalledQuest = new Artist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        Assert.assertEquals("A Tribe Called Quest", tribeCalledQuest.getName());
        Assert.assertEquals("09hVIj6vWgoCDtT03h8ZCa", tribeCalledQuest.getSpotifyId());
    }

    @Test
    public void addSingleArtistToDatabase() throws Exception {

        Artist tribeCalledQuest = new Artist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        HibernateUtil.saveObject(tribeCalledQuest);

        HibernateUtil.saveObject(tribeCalledQuest);

        //Artist retrievedArtist = HibernateUtil.getObjectById(Artist.class ,);

        List<Artist> artists = HibernateUtil.listObjects(Artist.class);

        for(Artist artist : artists){
            System.out.println(artist.getId() + ": " + artist.getName() + ", " + artist.getSpotifyId());
        }



    }
}
