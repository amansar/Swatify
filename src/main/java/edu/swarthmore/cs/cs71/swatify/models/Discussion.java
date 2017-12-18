package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
@DynamicUpdate
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String userName;
    private int userId;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;


    public Discussion() { }

    public Discussion(String title, int userId, String userName) {
        this.userId = userId;
        this.title = title;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public int getUserId() { return userId; }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public void setTitle(String title) { this.title = title; }

}
