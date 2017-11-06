package edu.swarthmore.cs.cs71.swatify.models;

public class Track extends MusicWork {

    private Integer lengthOfTrack;

    public Track() { }

    public void setLengthOfTrack(Integer lengthOfTrack) {
        this.lengthOfTrack = lengthOfTrack;
    }

    public Integer getLengthOfTrack() {

        return lengthOfTrack;
    }
}
