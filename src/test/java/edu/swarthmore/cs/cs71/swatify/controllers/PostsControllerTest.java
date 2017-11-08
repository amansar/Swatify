package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Post;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostsControllerTest {
    @Test
    public void createNewPost() {
        Post post = new Post("Test content", 1);

        Post createdPost = PostsController.createPost(post);

        assertEquals(post.getContent(), createdPost.getContent());
    }
}
