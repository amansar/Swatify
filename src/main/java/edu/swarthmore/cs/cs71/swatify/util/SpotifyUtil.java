package edu.swarthmore.cs.cs71.swatify.util;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.authentication.AuthorizationCodeGrantRequest;
import com.wrapper.spotify.models.AuthorizationCodeCredentials;
import edu.swarthmore.cs.cs71.swatify.models.User;

import java.util.Arrays;
import java.util.List;


public class SpotifyUtil {
    private static final String redirectURI = "http://localhost:3000/callback";
    private static final String state = "iPreventCSRFAttacks";
    private static final List<String> scopes = Arrays.asList("playlist-modify-public");

    public SpotifyUtil() { }

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
                  .accessToken("BQD9Gjz-oHFw-5RkUuozDLHhvglYQrsavLgA-NQp1IuGfl3OmtV1axCxF79nxQ5hoFq2MNyKmTIVR1CUL4NEXJJZzpd78QNBMfM6QyykQ5ckKcRLnQV1j5f8h80t4jpYyufJFLDrJwdtEzV72c2i1nPleXw7vQ0LllJ826TcdPx5h9MZ_w")
                  .refreshToken("AQAjqminBpv_sc43_kBj03bmQgqv6y0xkfDi9dz2qGvc83Z72RjfVp9luDwJbf-mczzenQAGy76ou74wOq_Pmr42rbW14Dyj9hlVM0bO_wNTco4kvmJM-vcLV_jX44jtyn4")
                  .build();
    }

    public static String getAuthorizeUrl() {
        return getApi().createAuthorizeURL(scopes, state);
    }
}



