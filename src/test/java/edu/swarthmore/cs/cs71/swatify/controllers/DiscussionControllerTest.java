package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DiscussionControllerTest {
    private static Post postFixture;
    private static Discussion discussionFixture;
    private static Discussion albumDiscussionFixture;
    private static User userFixture;

    @BeforeClass
    public static void createFixtures() {
        userFixture = new User("oliver", "onewman1@swarthmore.edu", "spotifyId");
        discussionFixture = new Discussion("Test discussion", userFixture.getId());
        albumDiscussionFixture = new Discussion("Test album discussion", userFixture.getId(), "47b7v7e");
        HibernateUtil.saveObject(userFixture);
        HibernateUtil.saveObject(discussionFixture);
        HibernateUtil.saveObject(albumDiscussionFixture);
        postFixture = new Post("Test post", userFixture.getId(), discussionFixture.getId());
        HibernateUtil.saveObject(postFixture);
    }

    @Test
    public void createNewDiscussion() {
        Discussion discussion = new Discussion("Testing discussion", 5);

        TestUtil.TestResponse res = request("POST", "/api/v1/discussions", GsonUtil.toJson(discussion));
        assertEquals(200, res.getStatus());

        Discussion createdDiscussion = GsonUtil.fromJson(Discussion.class, res.json().toString());

        assertEquals(discussion.getTitle(), createdDiscussion.getTitle());
    }

    @Test
    public void getDiscussion() {
        String url = String.format("/api/v1/discussions/%d", albumDiscussionFixture.getId());

        TestUtil.TestResponse res = request("GET", url);
        assertEquals(200, res.getStatus());

        Discussion gottenDiscussion = GsonUtil.fromJson(Discussion.class, res.json().toString());
        assertEquals(gottenDiscussion.getId(), albumDiscussionFixture.getId());
    }

    @Test
    public void updateDiscussion() {
        String url = String.format("/api/v1/discussions/%d", albumDiscussionFixture.getId());

        albumDiscussionFixture.setTitle("Updated title");

        TestUtil.TestResponse res = request("PUT", url, GsonUtil.toJson(albumDiscussionFixture));
        assertEquals(200, res.getStatus());

        Discussion updatedDiscussion = GsonUtil.fromJson(Discussion.class, res.json().toString());

        assertEquals(albumDiscussionFixture.getTitle(), updatedDiscussion.getTitle());
    }

    @Test
    public void deleteDiscussion() {
        Discussion discussionToDelete = new Discussion("Testing discussion", userFixture.getId(), albumDiscussionFixture.getAlbumSpotifyId());
        HibernateUtil.saveObject(discussionToDelete);

        String url = String.format("/api/v1/discussions/%d", discussionToDelete.getId());

        TestUtil.TestResponse res = request("DELETE", url);
        assertEquals(200, res.getStatus());

        Discussion deletedDiscussion = GsonUtil.fromJson(Discussion.class, res.json().toString());

        assertEquals(discussionToDelete.getTitle(), deletedDiscussion.getTitle());
    }
}
