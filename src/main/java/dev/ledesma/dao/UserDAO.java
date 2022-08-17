package dev.ledesma.dao;

import dev.ledesma.entity.User;

public interface UserDAO {

    User createUser(User user);
    User modifyUser(User user);


}
