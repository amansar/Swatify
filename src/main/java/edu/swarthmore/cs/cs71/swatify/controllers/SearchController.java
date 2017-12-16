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

import static spark.Spark.get;
import static spark.Spark.path;

public class SearchController {

    public SearchController() {
        path("/search", () -> {
           get("/:query", (request, response) -> searchArtists(request.params("query")));
        });
    }

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

    //search for users in our database

    public static List<List> search(String query){
        List<List> results = new ArrayList<>();
        results.add(searchAlbums(query).getResults());
        results.add(searchArtists(query).getResults());
        results.add(searchTracks(query).getResults());
        Collections.sort(results, (list1, list2) -> list2.size() - list1.size());

        return results;

    }

}
