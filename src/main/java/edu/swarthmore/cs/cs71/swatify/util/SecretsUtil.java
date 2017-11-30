package edu.swarthmore.cs.cs71.swatify.util;

import org.json.*;

public class SecretsUtil {
    private static String spotifyClientId;
    private static String spotifyClientSecret;

    public SecretsUtil() {
        JSONObject secretsJson = new JSONObject("src/main/resources/secrets.json");
        spotifyClientId = secretsJson.getString("spotify_client_id");
        spotifyClientSecret = secretsJson.getString("spotify_client_secret");
    }

    public static String getSpotifyClientId() {
        return spotifyClientId;
    }

    public static String getSpotifyClientSecret() {
        return spotifyClientSecret;
    }
}
