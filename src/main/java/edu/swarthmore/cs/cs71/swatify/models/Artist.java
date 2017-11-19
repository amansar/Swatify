package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@DynamicUpdate
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String spotifyId;
    private String name;



    public Artist() { }

    public Artist(String name, String spotifyId) {
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
