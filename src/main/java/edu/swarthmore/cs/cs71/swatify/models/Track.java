package edu.swarthmore.cs.cs71.swatify.models;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@DynamicUpdate
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double lengthOfTrack;

    private String titleOfWork;
    private String spotifyID;

    //maybe add length field if we plan on adding this in for both tracks and albums


    public Track() { }

    public void setLengthOfTrack(Double lengthOfTrack) {
        this.lengthOfTrack = lengthOfTrack;
    }

    public Double getLengthOfTrack() {

        return lengthOfTrack;
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

    public int getId() {
        return id;
    }
}
