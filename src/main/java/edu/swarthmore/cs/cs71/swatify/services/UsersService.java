package edu.swarthmore.cs.cs71.swatify.services;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UsersService {
    public static User getUser(int id) {
        return (User)HibernateUtil.getObjectById(User.class, id);
    }

    public static List<User> getAllUsers() {
        return new ArrayList();
    }

    public static User createUser(String username, String email) {
        User user = new User(username, email);
        HibernateUtil.saveObject(user);
        return user;
    }
}
