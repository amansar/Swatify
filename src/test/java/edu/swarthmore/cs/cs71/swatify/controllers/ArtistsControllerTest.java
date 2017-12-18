package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.test.ControllerTestBase;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static org.junit.Assert.assertEquals;

public class ArtistsControllerTest extends ControllerTestBase {
    private static User user;

    @BeforeClass
    public static void createFixtures() {
        user = new User();
    }

    @Test
    public void shouldGetArtist() {
        String knxwledgeId = "17Zu03OgBVxgLxWmRUyNOJ";
        String url = String.format("/api/v1/artists/%s", knxwledgeId);

        TestUtil.TestResponse res = request("GET", url);
        assertEquals(200, res.getStatus());

        Artist knxwledge = GsonUtil.fromJson(Artist.class, res.json().toString());
        assertEquals(knxwledgeId, knxwledge.getId());
    }

    @Test
    public void shouldGetArtistFollowers() {
//        Artist knxwledge = ArtistsController.getArtist("17Zu03OgBVxgLxWmRUyNOJ");
//        Followers knxwledgeFollowers = ArtistsController.getArtistFollowers("17Zu03OgBVxgLxWmRUyNOJ");
//
//        assertEquals(knxwledge.getFollowers().getTotal(), knxwledgeFollowers.getTotal());
    }

}
