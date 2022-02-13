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

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		licenseKeyService.deleteLicenseById(id);
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		model.addAttribute("license", licenseKeyService.getLicenseById(id));
		return "add_new_license";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("license") LicenseKey licenseKey, Model model) {
		licenseKeyService.saveLicenseKey(licenseKey);
		return "redirect:/";
	}
	
}
