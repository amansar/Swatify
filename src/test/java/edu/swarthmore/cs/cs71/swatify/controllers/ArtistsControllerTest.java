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
        user = new User("",
                        "BQD9Gjz-oHFw-5RkUuozDLHhvglYQrsavLgA-NQp1IuGfl3OmtV1axCxF79nxQ5hoFq2MNyKmTIVR1CUL4NEXJJZzpd78QNBMfM6QyykQ5ckKcRLnQV1j5f8h80t4jpYyufJFLDrJwdtEzV72c2i1nPleXw7vQ0LllJ826TcdPx5h9MZ_w",
                        "AQAjqminBpv_sc43_kBj03bmQgqv6y0xkfDi9dz2qGvc83Z72RjfVp9luDwJbf-mczzenQAGy76ou74wOq_Pmr42rbW14Dyj9hlVM0bO_wNTco4kvmJM-vcLV_jX44jtyn4");
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
}
