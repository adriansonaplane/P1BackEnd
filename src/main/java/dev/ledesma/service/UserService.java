package dev.ledesma.service;

import dev.ledesma.entity.User;

public interface UserService {

    User createUser(User user);
    User modifyUser(User user);
}
