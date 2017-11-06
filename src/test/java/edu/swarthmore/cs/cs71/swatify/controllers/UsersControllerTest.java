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

}
