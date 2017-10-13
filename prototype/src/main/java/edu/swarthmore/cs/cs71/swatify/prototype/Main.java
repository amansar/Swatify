package edu.swarthmore.cs.cs71.swatify.prototype;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;

import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        staticFiles.location("/static/html");
        Api spotify = getSpotifyAPI();

        get("/", (request, response) -> {
            // Returns index.html from staticFiles root.
            return null;
        });

        get("/spotify-auth", (request, response) -> {
            response.redirect(getSpotifyAuthorizeURL(getSpotifyAPI()));
            return null;
        });

        get("/spotify-callback", (request, response) -> {
            if (request.queryParams().contains("error")) {
                return "Failed to authenticate with Spotify" + request.queryParams("error");
            }

            String code = request.queryParams("code");

            AuthorizationCodeCredentials authorizationCodeCredentials = spotify.authorizationCodeGrant(code).build().get();
            spotify.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotify.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

            // Get a playlist for the user.
            String myId = spotify.getMe().build().get().getId();
            String playListUri = spotify.getPlaylistsForUser(myId).build().get().getItems().get(0).getUri();

            // Spotify widget from which the playlist can be played.
            return "<iframe src=\"https://open.spotify.com/embed?uri=" + playListUri + "\" width=\"300\" height=\"380\" frameborder=\"0\" allowtransparency=\"true\"></iframe>";
        });
    }

    private static Api getSpotifyAPI() {
        final String clientId = Secrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = Secrets.SPOTIFY_CLIENT_SECRET;
        final String redirectURI = "http://127.0.0.1:4567/spotify-callback";

        return Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectURI(redirectURI)
                .build();
    }

    private static String getSpotifyAuthorizeURL(Api api) {
        // What we'll actually want from the user.
        final List<String> scopes = Arrays.asList("user-read-private", "user-read-email", "user-library-read");

        final String state = "someState";

        return api.createAuthorizeURL(scopes, state);
    }
}
