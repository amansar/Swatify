package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class MusicWorksTest {

  @Test
    public void givenMultipleAlbums_returnAllAlbumsFromDatabase(){

      Album collegeDropouts = new Album();
      Date genericReleaseDate = new Date(63, 0, 16);
      collegeDropouts.setReleaseDate(genericReleaseDate);
      collegeDropouts.setSpotifyID("47b7v7e");
      collegeDropouts.setTitle("College Dropouts");

      assertEquals(genericReleaseDate, collegeDropouts.getReleaseDate());
      assertEquals("47b7v7e", collegeDropouts.getSpotifyID());
      assertEquals("College Dropouts", collegeDropouts.getTitle());
  }
}
