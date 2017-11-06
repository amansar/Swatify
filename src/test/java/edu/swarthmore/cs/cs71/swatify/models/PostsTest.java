package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.models.PublicActions.Post;
import org.junit.Assert;
import org.junit.Test;


public class PostsTest {
    @Test
    public void createPost() throws Exception {
        Post newPost = new Post("Test Post", 1);
        Assert.assertEquals("Test Post", newPost.getContent());
        Assert.assertEquals(1, newPost.getUserId());
        Assert.assertEquals(0, newPost.getId());
    }

    @Test
    public void changeContent() throws Exception {
        Post newPost = new Post("Test Post", 1);
        Assert.assertEquals("Test Post", newPost.getContent());
        newPost.setContent("updated");
        Assert.assertEquals("updated", newPost.getContent());
    }
}
