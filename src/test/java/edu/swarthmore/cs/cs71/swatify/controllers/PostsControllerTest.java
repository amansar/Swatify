package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.test.ControllerTestBase;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.TestResponse;
import static org.junit.Assert.*;

public class PostsControllerTest extends ControllerTestBase {
    private static Post postFixture;
    private static Discussion discussionFixture;
    private static User userFixture;

    @BeforeClass
    public static void createFixtures() {
        userFixture = new User("oliver", "accessToken", "refreshToken");
        discussionFixture = new Discussion();
        HibernateUtil.saveObject(userFixture);
        HibernateUtil.saveObject(discussionFixture);
        postFixture = new Post(userFixture, discussionFixture, "Test post");
        HibernateUtil.saveObject(postFixture);
    }

    @Test
    public void createNewPost() {
        Post post = new Post(userFixture, discussionFixture, "Test content");

        TestResponse res = request("POST", "/api/v1/posts", GsonUtil.toJson(post));
        assertEquals(200, res.getStatus());

        Post createdPost = GsonUtil.fromJson(Post.class, res.json().toString());

        assertEquals(post.getContent(), createdPost.getContent());
    }

    @Test
    public void getAPost() {
        String url = String.format("/api/v1/posts/%d", postFixture.getId());

        TestResponse res = request("GET", url);
        assertEquals(200, res.getStatus());

        Post gottenPost = GsonUtil.fromJson(Post.class, res.json().toString());
        assertEquals(gottenPost.getId(), postFixture.getId());
    }

    @Test
    public void updateAPost() {
        String url = String.format("/api/v1/posts/%d", postFixture.getId());

        postFixture.setContent("Updated content");

        TestResponse res = request("PUT", url, GsonUtil.toJson(postFixture));
        assertEquals(200, res.getStatus());

        Post updatedPost = GsonUtil.fromJson(Post.class, res.json().toString());

        assertEquals(postFixture.getContent(), updatedPost.getContent());
    }

    @Test
    public void deleteAPost() {
        Post postToDelete = new Post(userFixture, discussionFixture, "This post will be deleted");
        HibernateUtil.saveObject(postToDelete);

        String url = String.format("/api/v1/posts/%d", postToDelete.getId());

        TestResponse res = request("DELETE", url);
        assertEquals(200, res.getStatus());

        Post deletedPost = GsonUtil.fromJson(Post.class, res.json().toString());

        assertEquals(postToDelete.getContent(), deletedPost.getContent());
    }
}
