package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.*;
import com.wrapper.spotify.models.Track;
import edu.swarthmore.cs.cs71.swatify.models.*;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.path;

public class SearchController {

    public SearchController() {
        path("/search", () -> {
           get("/:id", (request, response) -> search(request.params("id")), GsonUtil::toJson);
           get("/:id/tracks", ((request, response) -> searchTracks(request.params("id"))), GsonUtil::toJson);
           get("/:id/artists", ((request, response) -> searchArtists("id")), GsonUtil::toJson);
            exception(IllegalArgumentException.class, (e, request, response) -> {
                response.status(400);
            });
        });
    }

    public static TrackSearchResults searchTracks(String query){
        final TrackSearchRequest request = SpotifyUtil.getApi().searchTracks(query).build();
        List<TrackSearchResult> searchResults = new ArrayList<>();

        try{
            final Page<Track> tracks = request.get();
            System.out.printf("Got %d results\n", tracks.getTotal());

            List<Track> resultTracks = tracks.getItems();
            for(Track track : resultTracks) {
                searchResults.add(new TrackSearchResult(track));
            }

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new TrackSearchResults(searchResults);
    }

    public static AlbumSearchResults searchAlbums(String query){
        final AlbumSearchRequest request = SpotifyUtil.getApi().searchAlbums(query).build();

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
        final ArtistSearchRequest request = SpotifyUtil.getApi().searchArtists(query).build();

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

    public static List<SearchResults> search(String query){
        System.out.println(query);
        List<SearchResults> results = new ArrayList<>();
        results.add(searchAlbums(query));
        results.add(searchArtists(query));
        results.add(searchTracks(query));
//        Collections.sort(results, (list1, list2) -> list2.numberOfResults() - list1.numberOfResults());

        return results;


    }

}
