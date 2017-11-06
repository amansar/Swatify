package edu.swarthmore.cs.cs71.swatify.models.PublicActions;

import javax.persistence.*;

@Entity
@Table
public class Post extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private int userId;

    public Post() { }

    public Post(String content, int userId) {
        this.userId = userId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) { this.content = content; }
}
