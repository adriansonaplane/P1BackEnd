package dev.ledesma.tests.dao;

import dev.ledesma.dao.UserDAO;
import dev.ledesma.dao.UserPostgresDAO;
import dev.ledesma.entity.User;
import dev.ledesma.entity.UserTitle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    static Logger logger = LogManager.getLogger(UserDAOTest.class.getName());
    private static UserDAO userDAO = new UserPostgresDAO();
    @Test
    void createUser() {

        User user = new User(0, "username", "password", "fname", "lname", UserTitle.PENDING);
        Assertions.assertNotNull(userDAO.createUser(user));
    }

    @Test
    void modifyUser() {
        User user = new User(1, "update", "update", "update", "update", UserTitle.USER);
        Assertions.assertNotNull(userDAO.modifyUser(user));

    }

}