package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class ArtistFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Artist artist;
    private User follower;

    public ArtistFollow() {
    }

    public ArtistFollow(User follower, Artist artist) {
        this.artist = artist;
        this.follower = follower;
    }

    public int getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public User getFollower() {
        return follower;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
