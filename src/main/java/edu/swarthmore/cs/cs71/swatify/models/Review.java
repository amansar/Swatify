package edu.swarthmore.cs.cs71.swatify.models;


import javax.persistence.*;

@Entity
@Table
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String content;
    private String albumId;
    private int stars;

//    @ManyToOne
//    @JoinColumn(name="discussion_id", nullable=true)
//    private Discussion discussion;

    public Review() { }

    public Review(String content, int userId, String albumId, int stars) {
        this.userId = userId;
        this.content = content;
        this.albumId = albumId;
        this.stars = stars;
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

    public String getAlbumId() {
        return albumId;
    }


}
