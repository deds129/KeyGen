package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.model.LicenseType;
import com.nchudinov.keygen.model.OsType;
import com.nchudinov.keygen.model.User;
import com.nchudinov.keygen.repository.LicenseKeyRepository;
import com.nchudinov.keygen.repository.OsTypesRepository;
import com.nchudinov.keygen.service.LicenseKeyService;
import com.nchudinov.keygen.service.LicenseTypesService;
import com.nchudinov.keygen.service.OsTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
	
	@Autowired
	private LicenseKeyService licenseKeyService;

	@Autowired
	private OsTypesService osTypesService;

	@Autowired
	private LicenseTypesService licenseTypesService;
	
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
	public List<LicenseType> getLicenseTypes(){
		return licenseTypesService.getAllLicenseTypes();
	}

	@ModelAttribute("operSystems")
	public List<OsType> getOsTypes(){
		return osTypesService.getAllOsTypes();
	}

	@GetMapping("/addLicense")
	public String add(Model model) {
		LicenseKey licenseKey = new LicenseKey();
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}
	
	@PostMapping("/saveLicense")
	public String saveLicense(@AuthenticationPrincipal User user, @ModelAttribute("license") LicenseKey licenseKey) {
		licenseKey.setAuthor(user);
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
