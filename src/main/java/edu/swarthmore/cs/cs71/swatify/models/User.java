package edu.swarthmore.cs.cs71.swatify.models;

import org.hibernate.annotations.DynamicUpdate;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;
    private ArrayList<User> following;  // figure out follow implementation
    private ArrayList<User> followers;
    private ArrayList<PublicAction> feed;
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        HibernateUtil.updateObject(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        HibernateUtil.updateObject(this);
    }

    public ArrayList<User> getFollowing() { return following;}

    public ArrayList<User> getFollowers() { return followers;}

    public void followUser(User user){
        following.add(user);
        HibernateUtil.updateObject(following); //need to update user object instead?
        HibernateUtil.updateObject(this);
    }

    public void unfollowUser(User user){
        if (following.contains(user)) {
            following.remove(user);
        }
        HibernateUtil.updateObject(following); //need to update user object instead?
        HibernateUtil.updateObject(this);
    }

    public ArrayList<PublicAction> getActions() {
        return feed;
    }
}
