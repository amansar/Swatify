package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Artist {

    @Id
    @GeneratedValue
    private int spotifyId;
    private String name;

    public Artist() { }

    public int getSpotifyId() {
        return spotifyId;
    }

    public String getName() {
        return name;
    }
}
