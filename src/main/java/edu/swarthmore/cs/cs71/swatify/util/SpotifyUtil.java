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

    public SpotifyUtil () {

        final String clientId = templatedSecrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = templatedSecrets.SPOTIFY_CLIENT_SECRET;

         spotifyApi = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();

        /* Create a request object. */
        final ClientCredentialsGrantRequest request = spotifyApi.clientCredentialsGrant().build();

        /* Use the request object to make the request, either asynchronously (getAsync) or synchronously (get) */
        final SettableFuture<ClientCredentials> responseFuture = request.getAsync();

        /* Add callbacks to handle success and failure */
        Futures.addCallback(responseFuture, new FutureCallback<ClientCredentials>() {
            @Override
            public void onSuccess(ClientCredentials clientCredentials) {
                /* The tokens were retrieved successfully! */
                System.out.println("Successfully retrieved an access token! " + clientCredentials.getAccessToken());
                System.out.println("The access token expires in " + clientCredentials.getExpiresIn() + " seconds");

                /* Set access token on the Api object so that it's used going forward */
                spotifyApi.setAccessToken(clientCredentials.getAccessToken());

                /* Please note that this flow does not return a refresh token.
                * That's only for the Authorization code flow */
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println( "An error occurred while getting the access token. This is probably caused by the client id or client secret is invalid.  ");
            }
        });

    }

<<<<<<< HEAD
    public static Api getSpotifyAPI() {
        final String clientId = Secrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = Secrets.SPOTIFY_CLIENT_SECRET;
=======
    private static Api getSpotifyAPI() {
        final String clientId = templatedSecrets.SPOTIFY_CLIENT_ID;
        final String clientSecret = templatedSecrets.SPOTIFY_CLIENT_SECRET;
>>>>>>> e81d6a36bb4bc0de96daa9d7fe59df485cbeb229
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


<<<<<<< HEAD
=======
    public  Artist getArtistInfo(String artistId){
        final ArtistRequest request = this.spotifyApi.getArtist(artistId).build();

        try{
            final Artist requestedArtist = request.get();

            return requestedArtist;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

        return null;
    }

    public  List<Album> getArtistAlbums (String artistId) {
        final AlbumsForArtistRequest albumsRequest = this.spotifyApi.getAlbumsForArtist(artistId).build();

        try{
            final List<Album> albums = (List<Album>) albumsRequest.get();
            return albums;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

        return null;
    }
>>>>>>> e81d6a36bb4bc0de96daa9d7fe59df485cbeb229
}



