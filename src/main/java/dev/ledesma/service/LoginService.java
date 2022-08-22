package dev.ledesma.service;

import dev.ledesma.entity.User;

public interface LoginService {

    User validateUser(String username, String password);

}
