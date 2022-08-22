package dev.ledesma.service;

import dev.ledesma.dao.UserDAO;
import dev.ledesma.entity.User;

public class LoginServiceImp implements LoginService {

    private UserDAO userDAO;

    public LoginServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User validateUser(String username, String password){

        User user = this.userDAO.getUser(username);

        if(user == null){
            throw new RuntimeException("No User Found With That Username");
        }

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Password Does Not Match");
        }

        return user;
    }
}
