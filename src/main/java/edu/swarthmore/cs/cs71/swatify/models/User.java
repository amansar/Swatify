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
    private List<User> following;
    private List<User> followers;
    private List<PublicAction> feed;

    public User() { }

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
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFollowing() { return following;}

    public List<User> getFollowers() { return followers;}

    public void followUser(User user){
        following.add(user);
        HibernateUtil.updateObject(following); //need to update user object instead?
    }

    public void unfollowUser(User user){
        if (following.contains(user)) {
            following.remove(user);
        }
        HibernateUtil.updateObject(following); //need to update user object instead?
    }

    public List<PublicAction> getActions() {
        return feed;
    }
}
