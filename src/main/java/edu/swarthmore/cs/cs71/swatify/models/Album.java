package edu.swarthmore.cs.cs71.swatify.models;

import java.util.Date;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@DynamicUpdate
public class Album extends MusicWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Date releaseDate;

    public Album() { }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }


}
