package com.example.services;

import com.example.model.User;

public interface UserMetier{
	User login(String username, String password);
}