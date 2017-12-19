package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.models.Album;
import edu.swarthmore.cs.cs71.swatify.test.ControllerTestBase;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static org.junit.Assert.assertEquals;

public class AlbumsControllerTest extends ControllerTestBase {
    @Test
    public void getAnAlbum() {
        String escapeId = "wpzak9OmQfrjyksuGwp0";
        TestUtil.TestResponse res = request("GET", "/api/v1/albums/" + escapeId);
        assertEquals(200, res.getStatus());

        Album escape = GsonUtil.fromJson(Album.class, res.json().toString());
        assertEquals(escape.getId(), escapeId);
        assertEquals(escape.getName(), "Escape");
    }
}
