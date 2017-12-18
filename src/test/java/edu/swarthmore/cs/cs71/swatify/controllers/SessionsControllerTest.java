package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.test.ControllerTestBase;
import edu.swarthmore.cs.cs71.swatify.test.TestUtil;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static edu.swarthmore.cs.cs71.swatify.test.TestUtil.request;
import static org.junit.Assert.assertEquals;

public class SessionsControllerTest extends ControllerTestBase {
    private static User userFixture;

    @BeforeClass
    public static void createFixtures() {
//        userFixture = new User("oliver", "onewman1@swarthmore.edu", "spotifyId");
//        discussionFixture = new Discussion("Test discussion", userFixture.getId());
//        albumDiscussionFixture = new Discussion("Test album discussion", userFixture.getId(), "47b7v7e");
//        HibernateUtil.saveObject(userFixture);
//        HibernateUtil.saveObject(discussionFixture);
//        HibernateUtil.saveObject(albumDiscussionFixture);
//        postFixture = new Post(userFixture, discussionFixture, "Test post");
//        HibernateUtil.saveObject(postFixture);
    }

    @Test
    public void tryToLogIn() {
        Discussion discussion = new Discussion("Testing discussion", 5);

        TestUtil.TestResponse res = request("POST", "/api/v1/discussions", GsonUtil.toJson(discussion));
        assertEquals(200, res.getStatus());

        Discussion createdDiscussion = GsonUtil.fromJson(Discussion.class, res.json().toString());

        assertEquals(discussion.getTitle(), createdDiscussion.getTitle());
    }
}
