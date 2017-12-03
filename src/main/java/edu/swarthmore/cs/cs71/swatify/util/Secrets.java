package edu.swarthmore.cs.cs71.swatify.util;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Secrets {
    private static String spotifyClientId;
    private static String spotifyClientSecret;

    public static String getSpotifyClientId() {
        if (spotifyClientId == null) {
            readSecretsFromJsonFile();
        }
        return spotifyClientId;
    }

    public static String getSpotifyClientSecret() {
        if (spotifyClientSecret == null) {
            readSecretsFromJsonFile();
        }
        return spotifyClientSecret;
    }

    public static void readSecretsFromJsonFile(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/secrets.json"));
        }
        catch (FileNotFoundException e) {
            return;
        }
        JSONObject jsonObject = new JSONObject(reader);

        spotifyClientId = jsonObject.get("spotifyClientId").toString();
        spotifyClientSecret = jsonObject.get("spotifyClientSecret").toString();
    }
}
