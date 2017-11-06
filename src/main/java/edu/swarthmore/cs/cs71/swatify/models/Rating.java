package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Rating extends PublicAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int stars;
    private int musicWorkId;

    public Rating(int userId, int stars, int musicWorkId) {
        this.userId = userId;
        this.stars = stars;
        this.musicWorkId = musicWorkId;
    }

    public int getId() {
        return id;
    }

    public int getMusicWorkId() { return musicWorkId; }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) { this.stars = stars; }
}