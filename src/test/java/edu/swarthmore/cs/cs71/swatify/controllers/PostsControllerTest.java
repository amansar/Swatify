package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.test.ControllerTestBase;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Before;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.TestResponse;
import static org.junit.Assert.*;

public class PostsControllerTest extends ControllerTestBase {
    private Post post;

    @Before
    public void createFixtures() {
        User user = new User("oliver", "onewman1@swarthmore.edu", "spotifyId");
        Discussion discussion = new Discussion();
        HibernateUtil.saveObject(discussion);
        this.post = new Post("Test post", user.getId(), discussion.getId());
        HibernateUtil.saveObject(this.post);
    }

    @Test
    public void createNewPost() {
        Post post = new Post("Test content", 1, 3);

        TestResponse res = request("POST", "/api/v1/posts", GsonUtil.toJson(post));
        assertEquals(200, res.getStatus());

        Post createdPost = GsonUtil.fromJson(Post.class, res.json().toString());

        assertEquals(post.getContent(), createdPost.getContent());
    }

    @Test
    public void getAPost() {
        String url = String.format("/api/v1/posts/%d", this.post.getId());

        TestResponse res = request("GET", url);
        assertEquals(200, res.getStatus());
//
//        Post gottenPost = GsonUtil.fromJson(Post.class, res.json().toString());
//        assertEquals(gottenPost.getId(), this.post.getId());
    }

    /*
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
    */
}
