package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.models.PublicActions.Comment;
import org.junit.Assert;
import org.junit.Test;

public class CommentsTest {
    @Test
    public void createComment() throws Exception {
        Comment newComment = new Comment("Test Comment", 1, 2);
        Assert.assertEquals("Test Comment", newComment.getContent());
        Assert.assertEquals(1, newComment.getUserId());
        Assert.assertEquals(2, newComment.getParentActionId());
        Assert.assertEquals(0, newComment.getId());
    }

    @Test
    public void changeContent() throws Exception {
        Comment newComment = new Comment("Test Comment", 1, 2);
        Assert.assertEquals("Test Comment", newComment.getContent());
        newComment.setContent("updated");
        Assert.assertEquals("updated", newComment.getContent());
    }
}
