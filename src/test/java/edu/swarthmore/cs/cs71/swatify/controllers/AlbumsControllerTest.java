package edu.swarthmore.cs.cs71.swatify.controllers;

import com.google.gson.JsonObject;
import edu.swarthmore.cs.cs71.swatify.Application;
import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

public class AlbumsControllerTest {

    @Before
    public void setUp() throws Exception {
        Application.setRoutes();
        awaitInitialization();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }


    @Test
    public void givenAlbum_generateCorrespondingAlbumFromDatabase(){
        Album collegeDropouts = new Album();
        Date genericReleaseDate = new Date(63, 1, 16);
        String collegeDropoutSpotifyID = "843ghg48";
        String collegeDropoutTitle = "College Dropouts";

        collegeDropouts.setReleaseDate(genericReleaseDate);
        collegeDropouts.setSpotifyID(collegeDropoutSpotifyID);
        collegeDropouts.setTitle(collegeDropoutTitle);

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("spotifyId", "843ghg48");
        requestBody.addProperty("titleOfWork", "College Dropouts");
        //requestBody.addProperty("Date", genericReleaseDate.toString());

        //TestUtil.TestResponse responseForPostingCollegeDropout = request("POST", "/albums?titleOfWork=College+Dropouts;spotifyID=843ghg48;releaseDate=1963-01-16");
        //TestUtil.TestResponse responseForPostingGraduation = request("POST", "/albums?titleOfWork=Graduation;spotifyID=i3v6h4;releaseDate=1963-01-16");

        TestUtil.TestResponse response = request("POST", "/api/v1/albums", requestBody.toString());

        JsonObject responseForPostingCollegeDropout = response.json();

        assertEquals(200, response.getStatus());
        //assertEquals(collegeDropouts.getSpotifyID(), responseForPostingCollegeDropout.get("spotifyId").getAsString());
        //assertEquals(collegeDropouts.getTitle(), responseForPostingCollegeDropout.get("titleOfWork").getAsString());
        //assertEquals(collegeDropouts.getReleaseDate().toString(), responseForPostingCollegeDropout.get("Date").getAsString());

    }
}
