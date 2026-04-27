package com.example.services;

import com.example.model.User;
import com.example.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserImplMetier implements UserMetier{
	
	private UserDAO userDAO;
	
	public void setUserDAO (UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User login(String username, String password) {
		User user = userDAO.findByUsernameAndPassword(username, password);
		return user;
	}
}