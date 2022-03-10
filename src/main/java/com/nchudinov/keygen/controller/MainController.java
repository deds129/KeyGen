package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.model.LicenseKeyTypes;
import com.nchudinov.keygen.model.OperSystems;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.service.LicenseKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	private LicenseKeyService licenseKeyService;
	
	@GetMapping("/")
	public String show(@RequestParam(required = false) String searchStr, Model model) {
		List<LicenseKey> licenseKeys = new ArrayList<>();
		
		if (searchStr != null && !searchStr.isEmpty()) {
			licenseKeys = licenseKeyService.getKeysByCustomer(searchStr);
		} else {
			licenseKeys = licenseKeyService.getAllKeys();
		}
		
		model.addAttribute("allLicenses", licenseKeys);
		model.addAttribute("searchStr", searchStr);
		return "admin_panel";
	}
	
	@ModelAttribute("licenseTypes")
	public LicenseKeyTypes[] getLicenseTypes(){
		return LicenseKeyTypes.values();
	}

	@ModelAttribute("operSystems")
	public OperSystems[] getOperSystems(){
		return OperSystems.values();
	}

	@GetMapping("/addLicense")
	public String add(Model model) {
		LicenseKey licenseKey = new LicenseKey();
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}
	
	@PostMapping("/saveLicense")
	public String saveLicense(@AuthenticationPrincipal User user, @ModelAttribute("license") LicenseKey licenseKey) {
		licenseKey.setUser(user);
		licenseKeyService.saveLicenseKey(licenseKey);
		return "redirect:/";
	}

	@PostMapping("/deleteLicense")
	public String  deleteLicense(@RequestParam("licId") int id, Model model) {
		licenseKeyService.deleteLicenseById(id);
		return "redirect:/";
	}

	@PostMapping("/updateLicense")
	public String  updateEmployee(@RequestParam("licId") int id, Model model) {
		LicenseKey licenseKey = licenseKeyService.getLicenseById(id);
		//must pass attribute with the same name
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}
	
}
