package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Rating extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int stars;
    private String spotifyId;

    public Rating() { }

    public Rating(int userId, int stars, String spotifyId) {
        this.userId = userId;
        this.stars = stars;
        this.spotifyId = spotifyId;
    }

    public int getId() {
        return id;
    }

    public String getSpotifyId() { return spotifyId; }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) { this.stars = stars; }
}