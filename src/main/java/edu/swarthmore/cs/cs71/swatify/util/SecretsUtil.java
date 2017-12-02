package edu.swarthmore.cs.cs71.swatify.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.json.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SecretsUtil {
    private String spotifyClientId;
    private String spotifyClientSecret;

    public SecretsUtil() {

    }

    public SecretsUtil (String clientId, String clientSecret){
        this.spotifyClientId = clientId;
        this.spotifyClientSecret = clientSecret;
    }

//    public void setSpotifyClientId(String spotifyClientId) {
//        this.spotifyClientId = spotifyClientId;
//    }
//
//    public void setSpotifyClientSecret(String spotifyClientSecret) {
//        this.spotifyClientSecret = spotifyClientSecret;
//    }

    public String getSpotifyClientId() {
        return spotifyClientId;
    }

    public String getSpotifyClientSecret() {
        return spotifyClientSecret;
    }
}
