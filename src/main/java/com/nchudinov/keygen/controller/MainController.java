package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.service.LicenseKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	private LicenseKeyService licenseKeyService;
	
	@GetMapping("/licenses")
	public String showLicenses(Model model) {
		List<LicenseKey> licenseKeys =  licenseKeyService.getAllKeys();
		model.addAttribute("licenses", licenseKeys);
		return "licenses";
	}
}
