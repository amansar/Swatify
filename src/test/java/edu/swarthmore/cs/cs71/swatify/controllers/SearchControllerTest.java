package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.SimpleAlbum;
import org.junit.Test;

import java.util.List;

public class SearchControllerTest {

    @Test
    public void shouldReturnTrackSearchResults() throws Exception {
        List<SimpleAlbum> albumResults = SearchController.searchAlbums("Aquemini");

        for(SimpleAlbum album : albumResults){
            System.out.println("Name: %s\nSpotify ID: %s\n\n");
        }
    }

    @Test
    public void shouldReturnAlbumSearchResults() throws Exception {

    }

    @Test
    public void shouldReturnArtistSearchResults() throws Exception {
        List<Artist> artistResults = SearchController.searchArtists("Frank Zappa");

        for(Artist artist : artistResults){
            System.out.printf("Name: %s\nSpotify ID:%s\nFollowers: %d\n\n",
                    artist.getName(), artist.getId(), artist.getFollowers().getTotal());
        }
    }
}
