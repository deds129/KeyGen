package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Role;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
	
	@GetMapping("{usrId}")
	private String editUser(@PathVariable("usrId") long id, Model model ){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("user", user );
		model.addAttribute("roles", Role.values());
		return "user_edit";
	}

	@PostMapping("{user}")
	private String updateUser(@ModelAttribute("user") User user){
		userRepository.save(user);
		return "redirect:/users";
	}
	
}
