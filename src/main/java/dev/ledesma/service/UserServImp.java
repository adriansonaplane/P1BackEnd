package dev.ledesma.service;

import dev.ledesma.dao.UserDAO;
import dev.ledesma.entity.User;

public class UserServImp implements UserService{
    private UserDAO userDAO;

    public UserServImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User createUser(User user) {

        User createdUser = this.userDAO.createUser(user);
        if(createdUser == null){
            throw new RuntimeException("Could not create user!");
        }else{
            return createdUser;
        }
    }

    @Override
    public User updateUser(User user) {

        User updatedUser = this.userDAO.modifyUser(user);

        if(updatedUser == null){
            throw new RuntimeException("Could not update user!");
        }else{
            return updatedUser;
        }
    }
}
