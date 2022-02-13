package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.User;

public interface UserService {
	
	User findUserByUsername(String username);
	void save(User user);
}
