package edu.swarthmore.cs.cs71.swatify.util;

import org.junit.*;

import static org.junit.Assert.assertThat;

public class HibernateUtilTest {
    @Test
    public void getSessionFactoryShouldNotBeNull() {
        assertThat(HibernateUtil.().openSession(), notNullValue());
    }
}
