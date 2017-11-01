package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String spotifyId;
    private String name;



    public Artist() { }

    public Artist(String name, String spotifyId) {
        this.name = name;
        this.spotifyId = spotifyId;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public String getName() {
        return name;
    }
}
