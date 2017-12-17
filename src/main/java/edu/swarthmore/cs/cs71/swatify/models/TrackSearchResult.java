package edu.swarthmore.cs.cs71.swatify.models;

import com.wrapper.spotify.models.*;
import com.wrapper.spotify.models.Track;

import java.util.List;

public class TrackSearchResult extends SearchResult{
    private String name;
    private String spotifyId;
    private String url;
    private List<SimpleArtist> artists;
    private int duration;
    private SimpleAlbum album;

    public TrackSearchResult() {
    }

    public TrackSearchResult(Track track) {
        this.spotifyId = track.getId();
        this.name = track.getName();
        this.album = track.getAlbum();
        this.duration = track.getDuration();
        this.artists = track.getArtists();
        this.url = "/tracks/" + track.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSpotifyId() {
        return super.getSpotifyId();
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    public List<SimpleArtist> getArtists() {
        return artists;
    }

    public int getDuration() {
        return duration;
    }

    public SimpleAlbum getAlbum() {
        return album;
    }
}
