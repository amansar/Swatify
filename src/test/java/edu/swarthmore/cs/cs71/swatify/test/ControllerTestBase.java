package edu.swarthmore.cs.cs71.swatify.test;

import edu.swarthmore.cs.cs71.swatify.Application;
import org.junit.After;
import org.junit.Before;

import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

public class ControllerTestBase {
    @Before
    public void setUp() throws Exception {
        Application.establishRoutes();

        awaitInitialization();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }
}
