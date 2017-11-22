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
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimpleAlbum;
import com.wrapper.spotify.models.Artist;


import java.io.IOException;
import java.util.List;


/*Will need to login application and get Client_ID and Client Secrets to use this application */
public class SpotifyUtil {

    private Api spotifyApi;

    public SpotifyUtil() { }


    public static Api getSpotifyAPI() {
        final String clientId = Secrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = Secrets.SPOTIFY_CLIENT_SECRET;

        final Api api = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();

        /* Create a request object. */
        final ClientCredentialsGrantRequest request = api.clientCredentialsGrant().build();

        /* Use the request object to make the request, either asynchronously (getAsync) or synchronously (get) */
        final SettableFuture<ClientCredentials> responseFuture = request.getAsync();

        /* Add callbacks to handle success and failure */
        Futures.addCallback(responseFuture, new FutureCallback<ClientCredentials>() {
            @Override
            public void onSuccess(ClientCredentials clientCredentials) {

                /* Set access token on the Api object so that it's used going forward */
                api.setAccessToken(clientCredentials.getAccessToken());

                /* Please note that this flow does not return a refresh token.
                * That's only for the Authorization code flow */
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println( "An error occurred while getting the access token. This is probably caused by the client id or client secret is invalid.  ");
            }
        });

        return api;
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



