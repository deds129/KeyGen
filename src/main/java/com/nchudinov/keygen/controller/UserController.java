package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Role;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.service.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/users")
	public String userList(Model model){
		model.addAttribute("users", userService.findAll());
		return "users_list";
	}
	
	@GetMapping("/users/{usrId}")
	public String editUser(@PathVariable("usrId") long id, Model model ){
		User user = userService.loadUserById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("user", user );
		model.addAttribute("roles", Role.values());
		return "user_edit";
	}

	@GetMapping("/users/registration")
	public String registerNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("roles", Role.values());
		return "user_edit";
	}

	@PostMapping("/saveUser")
	public String saveUpdatedUser(@Valid User user, Errors errors,
								   @RequestParam("file") MultipartFile file,
								   Model model) throws IOException {
		boolean pwdIsEqual = user.getPassword() != null || !user.getPassword().equals(user.getPasswordConfirm());
		if (!pwdIsEqual) {
			model.addAttribute("passwordError", "Passwords do not match");
		}
		if (errors != null && errors.hasErrors() || !pwdIsEqual) {
			model.addAttribute("roles", Role.values());
			return "user_edit";
		} else {
			if (file != null && !file.getOriginalFilename().isEmpty()) {
				File uploadDir = new File(uploadPath);

				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}

				String fileNameUUID = UUID.randomUUID().toString();
				String resultFilename = fileNameUUID + "."  + file.getOriginalFilename();
				file.transferTo(new File(uploadPath + "/" + resultFilename));
				user.setFileName(resultFilename);
			}
			
			if (!userService.save(user)) {
				//model.addAttribute("userError", "User exists!");
				//model.addAttribute("roles", Role.values());
				return "user_edit";
			}
		}
		return "redirect:/users";
	}
	
}
