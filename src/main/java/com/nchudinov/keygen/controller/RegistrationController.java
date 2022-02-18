package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Role;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String registration(){ 
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(User user, Map<String, Object> model) {
		User userFromDb = userService.findUserByUsername(user.getUsername());
		if (userFromDb != null) {
			model.put("message", "User already exists!");
			return "registration";
		}
		
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.ADMIN));
		userService.save(user);
		return "redirect:/login";
	}
}
