package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Post extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name="discussion_id", nullable=true)
    private Discussion discussion;

    public Post() { }

    public Post(String content, int userId) {
        this.userId = userId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) { this.content = content; }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public Discussion getDiscussion() {
        return discussion;
    }
}
