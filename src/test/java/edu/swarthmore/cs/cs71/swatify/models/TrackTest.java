package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class TrackTest {

    @Test
    public void setAndGetCorrectTrackFields(){

        Track kanyeSong= new Track();
        Timestamp genericReleaseDate = new Timestamp(0L);
        Double delta = 0.0;
        kanyeSong.setLengthOfTrack(2.34);
        kanyeSong.setSpotifyID("fdiubfdhiub");
        kanyeSong.setTitle("St. Pablo");

        assertEquals(2.34, kanyeSong.getLengthOfTrack(), delta);
        assertEquals("fdiubfdhiub", kanyeSong.getSpotifyID());
        assertEquals("St. Pablo", kanyeSong.getTitle());
    }
}
