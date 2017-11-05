package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MusicWorksTests {

  @Test
    public void givenMultipleAlbums_returnAllAlbumsFromDatabase(){
      List<Album> kanyeAlbums = new ArrayList<Album>();

      Album collegeDropouts = new Album();
      Date genericReleaseDate = new Date(63, 0, 16);
      collegeDropouts.setReleaseDate(genericReleaseDate);
      collegeDropouts.setSpotifyID(null);
      collegeDropouts.setTitle("College Dropouts");

      Album graduation = new Album();
      graduation.setReleaseDate(genericReleaseDate);
      graduation.setSpotifyID(null);
      graduation.setTitle("Graduation");

      kanyeAlbums.add(collegeDropouts);
      kanyeAlbums.add(graduation);

      HibernateUtil.saveObject(collegeDropouts);
      HibernateUtil.saveObject(graduation);

      Assert.assertEquals(kanyeAlbums,HibernateUtil.listObjects(Album.class));



  }
}
