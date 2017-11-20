package edu.swarthmore.cs.cs71.swatify.util;

import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController;
import edu.swarthmore.cs.cs71.swatify.models.SwatifyArtist;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SpotifyUtilTest {

    @Test
    public void shouldPrintAlbumResults(){
        SpotifyUtil spotifyUtil = new SpotifyUtil();
       // String lifeOfPabloId = spotifyUtil.searchAlbum("life of pablo");
        //System.out.println(lifeOfPabloId);

    }

    @Test
    public void getAlbum() throws IOException, WebApiException {
        SpotifyUtil spotifyUtil = new SpotifyUtil() ;
        final AlbumRequest request = spotifyUtil.getSpotifyAPI().getAlbum("7gsWAHLeT0w7es6FofOXk1").build();
        System.out.println(request);
        final com.wrapper.spotify.models.Album requestedAlbum = request.get();
        System.out.println(requestedAlbum);
    }




}
