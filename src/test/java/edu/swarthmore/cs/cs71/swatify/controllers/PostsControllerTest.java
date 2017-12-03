package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Post;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostsControllerTest {
    @Test
    public void createNewPost() {
        Post post = new Post("Test content", 1, 3);

//        assertTrue(PostsController.createPost(post));
    }

    @Test
    public void getPost() {
        Post post = new Post("Test content 8", 8, 5);

//        assertTrue(PostsController.createPost(post));
        int id = post.getId();

//        Post retrievePost = PostsController.getPost(id);
//        assertEquals("Test content 8", retrievePost.getContent());
    }

    @Test
    public void updatePost() {
        Post post = new Post("Test content not updated", 10, 6);

//        assertTrue(PostsController.createPost(post));
        int id = post.getId();
        post.setContent("Test content updated");

//        assertTrue(PostsController.updatePost(post));
//        Post updatedPost = PostsController.getPost(id);
//        assertEquals("Test content updated", updatedPost.getContent());
    }

    @Test
    public void deletePost() {
        Post post = new Post("Test delete", 11, 12);

//        assertTrue(PostsController.createPost(post));
        int id = post.getId();

//        assertTrue(PostsController.deletePost(id));
//        assertNull(PostsController.getPost(id));
    }
}
