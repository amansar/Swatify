package edu.swarthmore.cs.cs71.swatify.util;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.methods.AlbumsForArtistRequest;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/*Will need to login application and get Client_ID and Client Secrets to use this application */
public class SpotifyUtil {

    private Api spotifyApi;

    public SpotifyUtil () {

        final String clientId = Secrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = Secrets.SPOTIFY_CLIENT_SECRET;

         spotifyApi = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();

//        /* Create a request object. */
//        final ClientCredentialsGrantRequest request = spotifyApi.clientCredentialsGrant().build();
//
//        /* Use the request object to make the request, either asynchronously (getAsync) or synchronously (get) */
//        final SettableFuture<ClientCredentials> responseFuture = request.getAsync();

        /* Set the necessary scopes that the application will need from the user */
        final List<String> scopes = Arrays.asList("user-read-private", "user-read-email");

        /* Set a state. This is used to prevent cross site request forgeries. */
        final String state = "spotifyAuthState";

        String authorizeURL = spotifyApi.createAuthorizeURL(scopes, state);

        /* Application details necessary to get an access token */
        final String code = "code";

       /* Make a token request. Asynchronous requests are made with the .getAsync method and synchronous requests
       * are made with the .get method. This holds for all type of requests. */
        final SettableFuture<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = spotifyApi.authorizationCodeGrant(code).build().getAsync();

//        /* Add callbacks to handle success and failure */
//        Futures.addCallback(responseFuture, new FutureCallback<ClientCredentials>() {
//            @Override
//            public void onSuccess(ClientCredentials clientCredentials) {
//                /* The tokens were retrieved successfully! */
//                System.out.println("Successfully retrieved an access token! " + clientCredentials.getAccessToken());
//                System.out.println("The access token expires in " + clientCredentials.getExpiresIn() + " seconds");
//
//                /* Set access token on the Api object so that it's used going forward */
//                spotifyApi.setAccessToken(clientCredentials.getAccessToken());
//
//                /* Please note that this flow does not return a refresh token.
//                * That's only for the Authorization code flow */
//            }
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                System.out.println( "An error occurred while getting the access token. This is probably caused by the client id or client secret is invalid.  ");
//            }
//        });

        /* Add callbacks to handle success and failure */
        Futures.addCallback(authorizationCodeCredentialsFuture, new FutureCallback<AuthorizationCodeCredentials>() {
            @Override
            public void onSuccess(AuthorizationCodeCredentials authorizationCodeCredentials) {
    /* The tokens were retrieved successfully! */
                System.out.println("Successfully retrieved an access token! " + authorizationCodeCredentials.getAccessToken());
                System.out.println("The access token expires in " + authorizationCodeCredentials.getExpiresIn() + " seconds");
                System.out.println("Luckily, I can refresh it using this refresh token! " +     authorizationCodeCredentials.getRefreshToken());

    /* Set the access token and refresh token so that they are used whenever needed */
                spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
                spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
            }

            @Override
            public void onFailure(Throwable throwable) {
    /* Let's say that the client id is invalid, or the code has been used more than once,
     * the request will fail. Why it fails is written in the throwable's message. */

            }
        });

    }


    public static Api getSpotifyAPI() {
        final String clientId = Secrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = Secrets.SPOTIFY_CLIENT_SECRET;



        //final String redirectURI = "http://127.0.0.1:4567/api/token"; Don't need redirectURI unless we're doing User authentication
        return Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }



    public boolean searchAlbum (String query) {
        final AlbumSearchRequest request = this.spotifyApi.searchAlbums(query).offset(0).limit(3).build();

        try {
            final Page<SimpleAlbum> albumSearchResult = request.get();

            System.out.println("Printing results..");
            for (SimpleAlbum album : albumSearchResult.getItems()) {
                if(album.getName().toLowerCase().contains(query.toLowerCase())){
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }

        return false;
    }


}



