package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.models.UserFollow;
import org.junit.Assert;
import org.junit.Test;

public class UserFollowControllerTest {
    @Test
    public void shouldCreateFollow() throws Exception {
        User elsher = new User();
        User zach = new User();

        UserFollow elsherFollowsZach = new UserFollow(elsher, zach);

        boolean success = UserFollowController.saveUserFollow(elsherFollowsZach);

        Assert.assertTrue(success);
    }

    @Test
    public void shouldGetFollow() throws Exception {
        User elsher = new User();
        User zach = new User();
        UserFollow elsherFollowsZach = new UserFollow(elsher, zach);
        UserFollowController.saveUserFollow(elsherFollowsZach);

        int followId = elsherFollowsZach.getId();

        UserFollow returnedUserFollow = UserFollowController.getUserFollow(followId);
        Assert.assertEquals(elsherFollowsZach, returnedUserFollow);

    }
}
