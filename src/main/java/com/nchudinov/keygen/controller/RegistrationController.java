package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Role;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.service.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserServiceImpl userService;

	@Value("${upload.path}")
	private String uploadPath;
	
	@GetMapping("/registration")
	public String registration(Map<String, Object> model){ 
		User newUser = new User();
		model.put("newUser", newUser);
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(User user, Map<String, Object> model, @RequestParam("file") MultipartFile file) throws IOException {
		User userFromDb = userService.findUserByUsername(user.getUsername());
		if (userFromDb != null) {
			model.put("message", "User already exists!");
			return "registration";
		}

		if (file != null && !file.getOriginalFilename().isEmpty()) {
			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			String fileNameUUID = UUID.randomUUID().toString();
			String resultFilename = fileNameUUID + file.getOriginalFilename();
			file.transferTo(new File(uploadPath + "/" + resultFilename));
			user.setFileName(resultFilename);
		}
		
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		userService.save(user);
		return "redirect:/login";
	}
}
