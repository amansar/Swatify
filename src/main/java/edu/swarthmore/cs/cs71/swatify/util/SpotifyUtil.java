package edu.swarthmore.cs.cs71.swatify.util;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;
import edu.swarthmore.cs.cs71.swatify.models.User;

import java.util.Arrays;
import java.util.List;


public class SpotifyUtil {
    private static final String redirectURI = "http://localhost:4567/api/v1/spotify-auth/callback";
    private static final String state = "IPreventCSRFAttacks";
    private static final List<String> scopes = Arrays.asList("playlist-modify-public");

    public SpotifyUtil() { }

    public static Api getSpotifyAPI() {
        final String clientId = Secrets.getSpotifyClientId();
        final String clientSecret = Secrets.getSpotifyClientSecret();

        return Api.builder()
                  .clientId(clientId)
                  .clientSecret(clientSecret)
                  .redirectURI(redirectURI)
                  .build();
    }

    public static Api getSpotifyAPI(User user) {
        final String clientId = Secrets.getSpotifyClientId();
        final String clientSecret = Secrets.getSpotifyClientSecret();

        return Api.builder()
                  .clientId(clientId)
                  .clientSecret(clientSecret)
                  .accessToken(user.getSpotifyAccessToken())
                  .redirectURI(redirectURI)
                  .build();
    }

    public static String getAuthorizeUrl() {
        return getSpotifyAPI().createAuthorizeURL(scopes, state);
    }

    public static AuthorizationCodeCredentials getAcessCredentials(String code) {
        AuthorizationCodeCredentials credentials = null;
        try {
            credentials = getSpotifyAPI().authorizationCodeGrant(code).build().get();
        }
        catch (Exception e) { }

        return credentials;
    }
}



