package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class ArtistFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String artistSpotifyId;
    private User follower;

    public ArtistFollow() {
    }

    public ArtistFollow(User follower, String artistSpotifyId) {
        this.artistSpotifyId = artistSpotifyId;
        this.follower = follower;
    }

    public int getId() {
        return id;
    }

    public String getArtistSpotifyId() {
        return artistSpotifyId;
    }

    public User getFollower() {
        return follower;
    }
}
