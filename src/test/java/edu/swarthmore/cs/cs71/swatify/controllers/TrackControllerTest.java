package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Track;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class TrackControllerTest {

    @Test
    public void shouldCreateAndRetrieveCorrectTrack(){
        Track kanyeSong= new Track();
        Timestamp genericReleaseDate = new Timestamp(0L);
        Double delta = 0.0;
        kanyeSong.setLengthOfTrack(2.34);
        kanyeSong.setSpotifyID("fdiubfdhiub");
        kanyeSong.setTitle("St. Pablo");

        Track createdTrack = TracksController.createTrack(kanyeSong);

        assertEquals(kanyeSong.getTitle(), createdTrack.getTitle());
        assertEquals(kanyeSong.getLengthOfTrack(), createdTrack.getLengthOfTrack());
        assertEquals(kanyeSong.getSpotifyID(), createdTrack.getSpotifyID());
    }
}
