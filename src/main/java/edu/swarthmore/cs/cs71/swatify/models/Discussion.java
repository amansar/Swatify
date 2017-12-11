package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table
@DynamicUpdate
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int userId;

    public Discussion() { }

    public Discussion(String title, int userId) {
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getUserId() { return userId; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }
}
