package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class DiscussionsTest {
    @Test
    public void createDiscussion() throws Exception {
        Discussion newDiscussion = new Discussion("Test Discussion", 1);
        Assert.assertEquals("Test Discussion", newDiscussion.getTitle());
        Assert.assertEquals(1, newDiscussion.getUserId());
    }

    @Test
    public void changeTitle() throws Exception {
        Discussion newDiscussion = new Discussion("Test Discussion 2", 3);
        Assert.assertEquals("Test Discussion 2", newDiscussion.getTitle());
        newDiscussion.setTitle("updated");
        Assert.assertEquals("updated", newDiscussion.getTitle());
    }
}
