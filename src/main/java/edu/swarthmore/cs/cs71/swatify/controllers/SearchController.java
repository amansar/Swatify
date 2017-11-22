package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.*;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchController {

    public List<Track> searchTracks(String query){
        final TrackSearchRequest request = SpotifyUtil.getSpotifyAPI().searchTracks(query).build();

        try{
            final Page<Track> tracks = request.get();
            System.out.printf("Got %d results\n", tracks.getTotal());

            return tracks.getItems();

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new ArrayList<>();
    }

    public List<SimpleAlbum> searchAlbums(String query){
        final AlbumSearchRequest request = SpotifyUtil.getSpotifyAPI().searchAlbums(query).build();

        try{
            final Page<SimpleAlbum> albums = request.get();
            System.out.printf("Got %d results\n", albums.getTotal());

            return albums.getItems();

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new ArrayList<>();
    }

    public static List<Artist> searchArtists(String query){
        final ArtistSearchRequest request = SpotifyUtil.getSpotifyAPI().searchArtists(query).build();

        try{
            final Page<Artist> artists = request.get();
            System.out.printf("Got %d results\n", artists.getTotal());

            return artists.getItems();

        } catch (Exception e){
            System.out.println("Something went wrong! Got error " + e);
        }

        return new ArrayList<>();
    }


}
