package edu.swarthmore.cs.cs71.swatify.models;

import javax.persistence.*;

@Entity
@Table
public class UserFollow {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private User follower;
  private User following;

  public UserFollow() {
  }

  public UserFollow(User follower, User following) {
    this.following = following;
    this.follower = follower;
  }

  public int getId() {
    return id;
  }

  public User getFollowing() {
    return following;
  }

  public User getFollower() {
    return follower;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setFollowing(User following){
    this.following = following;
  }

  public void setFollower(User follower){
    this.follower = follower;
  }
}


