package dev.ledesma.service;

import dev.ledesma.dao.UserDAO;
import dev.ledesma.entity.User;

public class UserServImp implements UserService{
    private UserDAO userDAO;
    @Override
    public User createUser(User user) {

        if(this.userDAO.createUser(user) == null){
            throw new RuntimeException("Could not create user!");
        }else{
            return this.userDAO.createUser(user);
        }
    }

    @Override
    public User modifyUser(User user) {

        if(this.userDAO.modifyUser(user) == null){
            throw new RuntimeException("Could not update user!");
        }else{
            return this.userDAO.modifyUser(user);
        }
    }
}
