package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.test.ControllerTestBase;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostsControllerTest extends ControllerTestBase {
    @Test
    public void createNewPost() {
        Post post = new Post("Test content", 1);
        TestUtil.TestResponse res = TestUtil.request("POST", "/api/v1/posts", GsonUtil.toJson(post));
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(GsonUtil.toJson(post));
        System.out.println(res.json().toString());
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        assertEquals(200, res.getStatus());
    }

    /*
    @Test
    public void getPost() {
        Post post = new Post("Test content", 1);

//        assertTrue(PostsController.createPost(post));
        int id = post.getId();

//        Post retrievePost = PostsController.getPost(id);
//        assertEquals("Test content 8", retrievePost.getContent());
    }

    @Test
    public void updatePost() {
        Post post = new Post("Test content not updated", 10);

//        assertTrue(PostsController.createPost(post));
        int id = post.getId();
        post.setContent("Test content updated");

//        assertTrue(PostsController.updatePost(post));
//        Post updatedPost = PostsController.getPost(id);
//        assertEquals("Test content updated", updatedPost.getContent());
    }

    @Test
    public void deletePost() {
        Post post = new Post("Test delete", 11);

//        assertTrue(PostsController.createPost(post));
        int id = post.getId();

//        assertTrue(PostsController.deletePost(id));
//        assertNull(PostsController.getPost(id));
    }
    */
}
