package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.models.Track;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrackControllerTest {

    @Test
    public void shouldCreateAndRetrieveCorrectTrack(){
        Track kanyeSong= new Track();
        Timestamp genericReleaseDate = new Timestamp(0L);
        Double delta = 0.0;
        kanyeSong.setLengthOfTrack(2.34);
        kanyeSong.setSpotifyID("fdiubfdhiub");
        kanyeSong.setTitle("St. Pablo");

        assertTrue(TracksController.createTrack(kanyeSong));
    }

    @Test
    public void shouldGetExistingTrack() throws Exception {
        Track wolves= new Track();
        wolves.setTitle("wolves");
        wolves.setSpotifyID("7vhf8dbvh");
        wolves.setLengthOfTrack(2.56);

        HibernateUtil.saveObject(wolves);

        int id = wolves.getId();

        Track existingTrack = HibernateUtil.getObjectById(Track.class, id);

        Assert.assertEquals(wolves.getTitle(), existingTrack.getTitle());
        Assert.assertEquals(wolves.getSpotifyID(), existingTrack.getSpotifyID());
        Assert.assertEquals(id, existingTrack.getId());
    }
}
