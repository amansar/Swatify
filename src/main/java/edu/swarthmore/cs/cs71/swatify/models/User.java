package edu.swarthmore.cs.cs71.swatify.models;

import org.hibernate.annotations.DynamicUpdate;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;

    public User() { }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
