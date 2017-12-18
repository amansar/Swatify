package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Rating extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    private int stars;
    private String trackSpotifyId;

    public Rating() { }

    public Rating(User user, int stars, String trackSpotifyId) {
        this.user = user;
        this.stars = stars;
        this.trackSpotifyId = trackSpotifyId;
    }

    public int getId() {
        return this.id;
    }

    public String getTrackSpotifyId() {
        return this.trackSpotifyId;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}