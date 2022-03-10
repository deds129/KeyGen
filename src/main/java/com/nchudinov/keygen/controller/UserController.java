package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Role;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	private String userList(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "user_list";
	}
	
	@GetMapping("{user}")
	private String editUser(@PathVariable User user, Model model ){
		model.addAttribute("user", user);
		model.addAttribute("roles", Role.values());
		return "user_edit";
	}

	@PostMapping("{user}")
	private String updateUser(@PathVariable User user, Model model){
		userRepository.save(user);
		return "user_edit";
	}
	
}
