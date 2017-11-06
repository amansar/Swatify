package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersControllerTest {
    @Test
    public void shouldCreateANewUser() {
        User user = new User();
        user.setUsername("imjustatest");
        user.setEmail("imjustatest@example.com");

        User createdUser = UsersController.createUser(user);

        assertEquals(user.getUsername(), createdUser.getUsername());
    }


    @Test
    public void shouldNotAllowDuplicateUsernames() {
        User user1 = new User();
        User user2 = new User();
        user1.setUsername("user");
        user2.setUsername("user");
        user1.setEmail("user1@example.com");
        user2.setEmail("notuser1@example.com");

        UsersController.createUser(user1);

        UsersController.createUser(user2);
        assertEquals(null, user2.getId());
    }

    @Test
    public void shouldGetAnExistingUser() {
        String username = "userToGet";
        String email = "userToGet@example.com";

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);

        HibernateUtil.saveObject(user);

        int id = user.getId();

        User gottenUser = UsersController.getUser(id);

        assertEquals(username, gottenUser.getUsername());
        assertEquals(email, gottenUser.getEmail());
        assertEquals(id, gottenUser.getId());
    }

    @Test
    public void shouldDeleteAnExistingUser() {
        User user = new User();
        user.setUsername("anonymous1");
        user.setEmail("anonymous1@example.com");

        HibernateUtil.saveObject(user);

        int id = user.getId();

        User deletedUser = UsersController.deleteUser(id);

        assertEquals(deletedUser.getUsername(), user.getUsername());
        assertEquals(deletedUser.getEmail(), user.getEmail());
        assertEquals(deletedUser.getId(), id);

        User gottenUser = UsersController.getUser(id);

        assertEquals(null, gottenUser);
    }

    @Test
    public void shouldFailWhenDeletingNonExistentUser() {
        User failedDeletedUser = UsersController.deleteUser(1243124);
        assertEquals(null, failedDeletedUser);
    }

}
