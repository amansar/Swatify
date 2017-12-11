package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.*;
import edu.swarthmore.cs.cs71.swatify.models.AlbumSearchResults;
import edu.swarthmore.cs.cs71.swatify.models.ArtistSearchResults;
import edu.swarthmore.cs.cs71.swatify.models.SearchResults;
import edu.swarthmore.cs.cs71.swatify.models.TrackSearchResults;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchController {

    public static TrackSearchResults searchTracks(String query){
        final TrackSearchRequest request = SpotifyUtil.getSpotifyAPI().searchTracks(query).build();

        try{
            final Page<Track> tracks = request.get();
            System.out.printf("Got %d results\n", tracks.getTotal());

            return new TrackSearchResults(tracks.getItems());

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new TrackSearchResults(new ArrayList<>());
    }

    public static AlbumSearchResults searchAlbums(String query){
        final AlbumSearchRequest request = SpotifyUtil.getSpotifyAPI().searchAlbums(query).build();

        try{
            final Page<SimpleAlbum> albums = request.get();
            System.out.printf("Got %d results\n", albums.getTotal());

            return new AlbumSearchResults(albums.getItems());

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new AlbumSearchResults(new ArrayList<>());
    }

    public static ArtistSearchResults searchArtists(String query){
        final ArtistSearchRequest request = SpotifyUtil.getSpotifyAPI().searchArtists(query).build();

        try{
            final Page<Artist> artists = request.get();
            System.out.printf("Got %d results\n", artists.getTotal());

            return new ArtistSearchResults(artists.getItems());

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new ArtistSearchResults(new ArrayList<>());
    }

    // search users in our database

    public static void sortResults(List<SearchResults> searchResults){
        Collections.sort(searchResults, (list1, list2) -> list2.numberOfResults() - list1.numberOfResults());
    }

    public static List<SearchResults> search(String query){
        List<SearchResults> results = new ArrayList<>();
        results.add(searchAlbums(query));
        results.add(searchArtists(query));
        results.add(searchTracks(query));
        sortResults(results);

        return results;

    }

}
