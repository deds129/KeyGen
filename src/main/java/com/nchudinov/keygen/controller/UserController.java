package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Role;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@Autowired
	private UserRepository userService;
	
	@GetMapping
	private String userList(Model model){
		model.addAttribute("users", userService.findAll());
		return "user_list";
	}
	
	@GetMapping("{usrId}")
	private String editUser(@PathVariable("usrId") long id, Model model ){
		User user = userService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("user", user );
		model.addAttribute("roles", Role.values());
		return "user_edit";
	}

	@PostMapping("{user}")
	private String updateUser(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file) throws IOException {
		
		if (file != null && !file.getOriginalFilename().isEmpty()) {
			File uploadDir = new File(uploadPath);
			
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			String fileNameUUID = UUID.randomUUID().toString();
			String resultFilename = fileNameUUID + "." + file.getOriginalFilename();
			file.transferTo(new File(uploadPath + "/" + resultFilename));
			user.setFileName(resultFilename);
		}
		userService.save(user);
		return "redirect:/users";
	}
	
}
