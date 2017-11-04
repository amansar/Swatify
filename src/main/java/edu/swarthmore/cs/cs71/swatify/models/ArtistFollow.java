package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class ArtistFollow {
    private Artist artist;
    private User follower;

    public ArtistFollow() {
    }

    public ArtistFollow(Artist artist, User follower) {
        this.artist = artist;
        this.follower = follower;
    }
}
