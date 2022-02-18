package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.service.LicenseKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	private LicenseKeyService licenseKeyService;
	
	@GetMapping("/")
	public String show(Model model) {
		List<LicenseKey> licenseKeys =  licenseKeyService.getAllKeys();
		model.addAttribute("allLicenses", licenseKeys);
		return "admin_panel";
	}

	@GetMapping("/addLicense")
	public String add(Model model) {
		LicenseKey licenseKey = new LicenseKey();
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}
	
	@PostMapping("/saveLicense")
	public String saveLicense(@ModelAttribute("license") LicenseKey licenseKey) {
		licenseKeyService.saveLicenseKey(licenseKey);
		return "redirect:/";
	}

	@PostMapping("/deleteLicense")
	public String  deleteLicense(@RequestParam("licId") int id, Model model) {
		licenseKeyService.deleteLicenseById(id);
		return "redirect:/";
	}

	@RequestMapping("/updateLicense")
	public String  updateEmployee(@RequestParam("licId") int id, Model model) {
		LicenseKey licenseKey = licenseKeyService.getLicenseById(id);
		//must pass attribute with the same name
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}
	
}
