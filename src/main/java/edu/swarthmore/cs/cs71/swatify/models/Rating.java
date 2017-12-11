package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Rating extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int stars;
    private int spotifyId;

    public Rating(User user, int stars, int spotifyId) {
        super(user);
        this.stars = stars;
        this.spotifyId = spotifyId;
    }

    public int getId() {
        return this.id;
    }

    public int getSpotifyId() {
        return this.spotifyId;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}