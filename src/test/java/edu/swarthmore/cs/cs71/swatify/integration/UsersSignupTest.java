package edu.swarthmore.cs.cs71.swatify.integration;

import edu.swarthmore.cs.cs71.swatify.Application;
import org.junit.After;
import org.junit.Before;

import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

public class UsersSignupTest {
    @Before
    public void setUp() throws Exception {
        Application.setRoutes();
        awaitInitialization();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }
}
