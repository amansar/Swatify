package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Comment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CommentsControllerTest {
    @Test
    public void createNewComment() {
        Comment comment = new Comment("Test content", 1, 1);

        assertTrue(CommentsController.createComment(comment));
    }

    @Test
    public void getComment() {
        Comment comment = new Comment("Test content 8", 8, 1);

        assertTrue(CommentsController.createComment(comment));
        int id = comment.getId();

        Comment retrieveComment= CommentsController.getComment(id);
        assertEquals("Test content 8", retrieveComment.getContent());
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment("Test content not updated", 10, 10);

        assertTrue(CommentsController.createComment(comment));
        int id = comment.getId();
        comment.setContent("Test content updated");

        assertTrue(CommentsController.updateComment(comment));
        Comment updatedComment = CommentsController.getComment(id);
        assertEquals("Test content updated", updatedComment.getContent());
    }

    @Test
    public void deleteComment() {
        Comment comment = new Comment("Test delete", 11, 12);

        assertTrue(CommentsController.createComment(comment));
        int id = comment.getId();

        assertTrue(CommentsController.deleteComment(id));
        assertNull(CommentsController.getComment(id));
    }
}
