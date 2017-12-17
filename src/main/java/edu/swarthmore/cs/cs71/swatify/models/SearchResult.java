package edu.swarthmore.cs.cs71.swatify.models;

import com.wrapper.spotify.models.Artist;

import java.util.List;

public class SearchResult {
    private String name;
    private String spotifyId;
    private String url;

    public SearchResult() {
    }

    public String getName() {
        return name;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public String getUrl() {
        return url;
    }
}
