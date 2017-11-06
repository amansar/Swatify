package edu.swarthmore.cs.cs71.swatify.controllers;

import com.google.gson.JsonObject;
import edu.swarthmore.cs.cs71.swatify.Application;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil.TestResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static org.junit.Assert.assertEquals;
import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

public class UsersControllerTest {
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
    public void shouldCreateANewUser() {
        String username = "imjustatest";
        String email = "imjustatest@example.com";

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("username", username);
        requestBody.addProperty("email", email);

        TestResponse response = request("POST", "/api/v1/users", requestBody.toString());
        JsonObject responseJson = response.json();
        assertEquals(200, response.getStatus());
        assertEquals(username, responseJson.get("username").getAsString());
        assertEquals(email, responseJson.get("email").getAsString());
    }

    @Test
    public void shouldGetAnExistingUser() {
        String username = "userToGet";
        String email = "userToGet@example.com";

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("username", username);
        requestBody.addProperty("email", email);

        TestResponse createResponse = request("POST", "/api/v1/users", requestBody.toString());
        int id = createResponse.json().get("id").getAsInt();

        TestResponse getResponse = request("GET", String.format("api/v1/users/%d", id));
        assertEquals(200, getResponse.getStatus());
        JsonObject getResponseJson = getResponse.json();

        assertEquals(username, getResponseJson.get("username").getAsString());
        assertEquals(email, getResponseJson.get("email").getAsString());
        assertEquals(id, getResponseJson.get("id").getAsInt());
    }
}
