package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import org.junit.Test;

import java.util.Map;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static org.junit.Assert.assertEquals;

public class UsersControllerTest {
    @Test
    public void aNewUserShouldBeCreated() {
        TestUtil.TestResponse response = request("POST", "/users?username=oliver&email=oliver@example.com");
        Map<String, String> json = response.json();
        assertEquals(200, response.status);
        assertEquals("oliver", json.get("username"));
        assertEquals("oliver@example.com", json.get("email"));
    }
}
