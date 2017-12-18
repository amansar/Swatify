package edu.swarthmore.cs.cs71.swatify.util;

import com.wrapper.spotify.Api;
import edu.swarthmore.cs.cs71.swatify.models.User;

import java.util.Arrays;
import java.util.List;


public class SpotifyUtil {
    private static final String redirectURI = "http://localhost:3000/callback";
    private static final String state = "iPreventCSRFAttacks";
    private static final List<String> scopes = Arrays.asList("playlist-modify-public");

    public SpotifyUtil() {
    }

    public static Api getApi() {
        final String clientId = Secrets.getSpotifyClientId();
        final String clientSecret = Secrets.getSpotifyClientSecret();

        return Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectURI(redirectURI)
                .build();
    }

    public static Api getApi(User user) {
        return Api.builder()
                .accessToken(user.getSpotifyAccessToken())
                .refreshToken(user.getSpotifyRefreshToken())
                .build();
    }

    public static String getAuthorizeUrl() {
        return getApi().createAuthorizeURL(scopes, state);
    }
}



