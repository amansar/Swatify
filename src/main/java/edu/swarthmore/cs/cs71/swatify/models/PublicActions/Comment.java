package edu.swarthmore.cs.cs71.swatify.models.PublicActions;

import javax.persistence.*;

/**
 * Comment class that extends PublicAction.
 */
@Entity
@Table
public class Comment extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private int userId;
    private int parentActionId;

    public Comment() { }

    public Comment(String content, int userId, int parentActionId) {
        this.content = content;
        this.userId = userId;
        this.parentActionId = parentActionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }

    public int getParentActionId() { return parentActionId; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) { this.content = content; }
}
