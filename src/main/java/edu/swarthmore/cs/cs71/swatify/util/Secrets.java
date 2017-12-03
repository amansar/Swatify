package edu.swarthmore.cs.cs71.swatify.util;

public class Secrets {
    private String spotifyClientId;
    private String spotifyClientSecret;

    public Secrets() {

    }

    public Secrets(String clientId, String clientSecret){
        this.spotifyClientId = clientId;
        this.spotifyClientSecret = clientSecret;
    }


    public String getSpotifyClientId() {
        return spotifyClientId;
    }

    public String getSpotifyClientSecret() {
        return spotifyClientSecret;
    }
}
