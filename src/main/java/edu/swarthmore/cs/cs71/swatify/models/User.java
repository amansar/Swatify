package edu.swarthmore.cs.cs71.swatify.models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;

    @Column(unique = true)
    @NotBlank
    private String username;

    @Column(unique = true)
    @NotBlank
    private String email;

    @Column(unique = true)
    @NotBlank
    private String spotifyId;

    @NotBlank
    private String spotifyAccessToken;

    public User() { }

    public User(String username, String email, String spotifyId) {
        this.username = username;
        this.email = email;
        this.spotifyId = spotifyId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public String getSpotifyAccessToken() {
        return spotifyAccessToken;
    };
}
