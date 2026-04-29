package com.example.services;

import com.example.model.User;
import com.example.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserImplMetier implements UserMetier {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User login(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }
}