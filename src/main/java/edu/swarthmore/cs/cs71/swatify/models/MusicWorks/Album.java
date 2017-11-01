package edu.swarthmore.cs.cs71.swatify.models.MusicWorks;

import java.util.Date;

public class Album extends MusicWork {

    private Date releaseDate;

    public Album() { }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }


}
