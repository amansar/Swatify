package edu.swarthmore.cs.cs71.swatify.models;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@DynamicUpdate
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ColumnDefault("NULL")
    private Timestamp releaseDate;

    private String titleOfWork;
    private String spotifyID;

    //maybe add length field if we plan on adding this in for both tracks and albums

    public Album() { }

    public int getId() {
        return id;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getSpotifyID() {
        return spotifyID;
    }

    public String getTitle() {

        return titleOfWork;
    }



    public void setSpotifyID(String spotifyId){
        this.spotifyID = spotifyId;
    }

    public void setTitle(String title){
        this.titleOfWork = title;
    }

}
