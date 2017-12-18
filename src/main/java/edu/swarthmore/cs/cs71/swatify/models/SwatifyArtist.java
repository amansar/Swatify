package edu.swarthmore.cs.cs71.swatify.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@DynamicUpdate
public class SwatifyArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String spotifyId;
    private String name;
    private int numFollowers;


    public SwatifyArtist() {
    }

    public SwatifyArtist(String name, String spotifyId) {
        this.name = name;
        this.spotifyId = spotifyId;
    }

    public int getId() {
        return id;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public String getName() {
        return name;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public void setName(String name) {
        this.name = name;
    }


}
