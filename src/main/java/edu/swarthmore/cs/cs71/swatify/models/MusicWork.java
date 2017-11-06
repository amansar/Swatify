package edu.swarthmore.cs.cs71.swatify.models;

public class MusicWork {
    private String titleOfWork;
    private String spotifyID;

    //maybe add length field if we plan on adding this in for both tracks and albums

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
