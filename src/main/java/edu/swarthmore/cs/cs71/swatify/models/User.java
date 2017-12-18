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

    @NotBlank
    private String spotifyAccessToken;

    @NotBlank
    private String spotifyRefreshToken;

    public User() { }

    public User(String username, String spotifyAccessToken, String spotifyRefreshToken) {
        this.username = username;
        this.spotifyAccessToken = spotifyAccessToken;
        this.spotifyRefreshToken = spotifyRefreshToken;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSpotifyAccessToken() {
        return spotifyAccessToken;
    };

    public String getSpotifyRefreshToken() {
        return spotifyRefreshToken;
    };

    public void setSpotifyAccessToken(String spotifyAccessToken) {
        this.spotifyAccessToken = spotifyAccessToken;
    };

    public void setSpotifyRefreshToken(String spotifyRefreshToken) {
        this.spotifyRefreshToken = spotifyRefreshToken;
    };
}
