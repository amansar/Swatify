package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsersControllerTest {
    @Test
    public void shouldCreateANewUser() {
        User user = new User();
        user.setUsername("imjustatest");
        user.setEmail("imjustatest@example.com");

        assertTrue(UsersController.createUser(user));

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

        assertFalse(UsersController.createUser(user2));
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

        boolean deletedUser = UsersController.deleteUser(id);

        assertTrue(deletedUser);

        User gottenUser = UsersController.getUser(id);

        assertEquals(null, gottenUser);
    }

    @Test
    public void shouldFailWhenDeletingNonExistentUser() {
        assertFalse(UsersController.deleteUser(1243124));
    }

}
