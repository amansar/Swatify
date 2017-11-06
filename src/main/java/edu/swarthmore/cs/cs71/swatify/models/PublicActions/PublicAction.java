package edu.swarthmore.cs.cs71.swatify.models.PublicActions;

import java.time.LocalDateTime;

/**
 * Superclass for PublicAction
 * Subclassed by Post, Comment, and Rating classes
 */
public class PublicAction {
    private LocalDateTime dateCreated;
    private int userId;
    private int id;


    public PublicAction() { }

    public PublicAction(int userId) {
        this.userId = userId;
        this.dateCreated = LocalDateTime.now();
    }

    /**
     * Returns the database Id of the user who created the PublicAction
     */
    public int getUserId(){ return userId; };

    public LocalDateTime getDateCreated() { return this.dateCreated; }

    public void setUserId(int userId){ this.userId = userId; }
}
