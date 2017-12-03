package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Post extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private int discussionId;

//    @ManyToOne
//    @JoinColumn(name="discussion_id", nullable=true)
//    private Discussion discussion;

    public Post() { }

    public Post(String content, int userId, int discussionId) {
        this.userId = userId;
        this.content = content;
        this.discussionId = discussionId;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) { this.content = content; }

//    public void setDiscussion(Discussion discussion) {
//        this.discussion = discussion;
//    }

    public int getDiscussionId() {
        return discussionId;
    }
}
