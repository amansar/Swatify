package edu.swarthmore.cs.cs71.swatify.models;

import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@DynamicUpdate
public class Album extends MusicWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp releaseDate;

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

}
