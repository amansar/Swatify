package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.SimpleAlbum;
import com.wrapper.spotify.models.SimpleArtist;
import com.wrapper.spotify.models.Track;
import edu.swarthmore.cs.cs71.swatify.models.AlbumSearchResults;
import edu.swarthmore.cs.cs71.swatify.models.ArtistSearchResults;
import edu.swarthmore.cs.cs71.swatify.models.SearchResults;
import edu.swarthmore.cs.cs71.swatify.models.TrackSearchResults;
import org.junit.Test;

import java.util.List;

public class SearchControllerTest {

    @Test
    public void shouldReturnTrackSearchResults() throws Exception {
        TrackSearchResults trackResults = SearchController.searchTracks("Before the Beginning");
        trackResults.printResults();
    }

    @Test
    public void shouldReturnAlbumSearchResults() throws Exception {

        AlbumSearchResults albumResults = SearchController.searchAlbums("Aquemini");
        albumResults.printResults();
    }

    @Test
    public void shouldReturnArtistSearchResults() throws Exception {
        ArtistSearchResults artistResults = SearchController.searchArtists("Frank Zappa");
        artistResults.printResults();
    }

    @Test
    public void shouldGetAllResults() throws Exception {
        List<SearchResults> searchResults = SearchController.search("Yes");
        for(SearchResults resultCategory : searchResults){
            resultCategory.printResults();
        }
    }
}
