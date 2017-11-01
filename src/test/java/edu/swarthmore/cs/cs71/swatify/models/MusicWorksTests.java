package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.models.MusicWorks.Album;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MusicWorksTests {

  @Test
    public void givenAlbumJava_generatedAlbumPOJO(){
      Album album = new Album();
      Date releaseDate = new Date(63, 0, 16);

      album.setReleaseDate(releaseDate);
      album.setSpotifyID(null);
      album.setTitle("College Dropouts");

      HibernateUtil.saveObject(album);



  }
}
