package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Assert;
import org.junit.Test;

public class UserFollowTest {

  @Test
  public void shouldCreateUserFollow() throws Exception {
    User elsher = new User();
    User zach = new User();
    UserFollow elsherFollowsZach = new UserFollow(elsher, zach);

    Assert.assertEquals(elsher, elsherFollowsZach.getFollower());
    Assert.assertEquals(zach, elsherFollowzZach.getFollowing());
  }
}
