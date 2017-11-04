package edu.swarthmore.cs.cs71.swatify.test;

import com.google.gson.Gson;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Source: https://github.com/mscharhag/blog-examples/blob/master/sparkdemo/src/test/java/com/mscharhag/sparkdemo/UserControllerIntegrationTest.java
 */

public class TestUtil {
    /**
     * Make an HTTP request to the local server.
     * @param method The HTTP method to use.
     * @param path The path (at localhost) to make the request to.
     * @return A TestResponse object containing the body and status of the response.
     */
    public static TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    public static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }
}
