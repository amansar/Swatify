package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DiscussionControllerTest {
    @Test
    public void createNewDiscussion() {
        Discussion discussion = new Discussion("Test discussion", 1, "testUser4");

        assertTrue(DiscussionsController.createDiscussion(discussion));
    }

    @Test
    public void getDiscussion() {
        Discussion discussion = new Discussion("Test discussion", 8, "testUser5");

        assertTrue(DiscussionsController.createDiscussion(discussion));
        int id = discussion.getId();

        Discussion retrieveDiscussion = DiscussionsController.getDiscussion(id);
        assertEquals("Test discussion", retrieveDiscussion.getTitle());
    }

    @Test
    public void updateDiscussion() {
        Discussion discussion = new Discussion("Test title not updated", 10, "testUser6");

        assertTrue(DiscussionsController.createDiscussion(discussion));
        int id = discussion.getId();
        discussion.setTitle("Test title updated");

        assertTrue(DiscussionsController.updateDiscussion(discussion));
        Discussion updatedDiscussion = DiscussionsController.getDiscussion(id);
        assertEquals("Test title updated", updatedDiscussion.getTitle());
    }

    @Test
    public void deleteDiscussion() {
        Discussion discussion = new Discussion("Test delete", 11, "testUser7");

        assertTrue(DiscussionsController.createDiscussion(discussion));
        int id = discussion.getId();

        assertTrue(DiscussionsController.deleteDiscussion(id));
        assertNull(DiscussionsController.getDiscussion(id));
    }

    @Test
    public void testCreatePath() {
        Discussion test = GsonUtil.fromJson(Discussion.class, "{userId: 5, title: 'Test', userName: 'testUser10'}");
        assertTrue(DiscussionsController.createDiscussion(test));
    }
}
