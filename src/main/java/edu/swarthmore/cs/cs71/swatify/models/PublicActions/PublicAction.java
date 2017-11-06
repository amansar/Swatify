package edu.swarthmore.cs.cs71.swatify.models.PublicActions;

import java.time.LocalDateTime;

/**
 * Superclass for PublicAction
 * Subclassed by Post, Comment, and Rating classes
 */
public class PublicAction {
    protected int userId;

    public PublicAction() { }


    /**
     * Returns the database Id of the user who created the PublicAction
     */
    public int getUserId(){ return this.userId; };

    public void setUserId(int userId){ this.userId = userId; }
}
