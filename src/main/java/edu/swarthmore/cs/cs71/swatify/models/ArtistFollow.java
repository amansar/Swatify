package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class ArtistFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SwatifyArtist swatifyArtist;
    private User follower;

    public ArtistFollow() {
    }

    public ArtistFollow(User follower, SwatifyArtist swatifyArtist) {
        this.swatifyArtist = swatifyArtist;
        this.follower = follower;
    }

    public int getId() {
        return id;
    }

    public SwatifyArtist getSwatifyArtist() {
        return swatifyArtist;
    }

    public User getFollower() {
        return follower;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSwatifyArtist(SwatifyArtist swatifyArtist) {
        this.swatifyArtist = swatifyArtist;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
