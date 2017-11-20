package edu.swarthmore.cs.cs71.swatify.util;

import com.wrapper.spotify.models.Artist;
import org.junit.Assert;
import org.junit.Test;

public class SpotifyUtilTest {

    @Test
    public void shouldPrintAlbumResults(){
        SpotifyUtil spotifyUtil = new SpotifyUtil();
    }

    @Test
    public void shouldGetArtistInfo() throws Exception {
        edu.swarthmore.cs.cs71.swatify.models.Artist knxwledge = new edu.swarthmore.cs.cs71.swatify.models.Artist("Knxwledge", "17Zu03OgBVxgLxWmRUyNOJ");
        Artist spotifyArtist = SpotifyUtil.getArtistInfo(knxwledge.getSpotifyId());
    }
}
