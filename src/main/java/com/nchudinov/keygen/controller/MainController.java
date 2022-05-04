package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.*;
import com.nchudinov.keygen.service.*;
import com.nchudinov.keygen.service.impls.CustomersServiceImpl;
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

	@Autowired
	private OsTypesService osTypesService;

	@Autowired
	private LicenseTypesService licenseTypesService;

	@Autowired
	private FeaturesService featuresService;
	
	@Autowired
	private DbTypesService dbTypesService;

	@Autowired
	private CustomersServiceImpl customersService;
	
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

	@ModelAttribute("customers")
	public List<Customer> getCustomers(){
		return customersService.getAllCustomers();
	}

	@ModelAttribute("features")
	public List<Feature> getFeatures(){
		return featuresService.getAllFeatures();
	}

	@ModelAttribute("dbTypes")
	public List<DbType> getDbTypes(){
		return dbTypesService.getAllDbTypes();
	}

	@GetMapping("/addLicense")
	public String add(Model model) {
		LicenseKey licenseKey = new LicenseKey();
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}

	@PostMapping("/updateLicense")
	public String  updateLicense(@RequestParam("licId") int id, Model model) {
		LicenseKey licenseKey = licenseKeyService.getLicenseById(id);
		//must pass attribute with the same name
		model.addAttribute("license", licenseKey);
		return "add_new_license";
	}
	
	@PostMapping("/saveLicense")
	public String saveLicense(@AuthenticationPrincipal User user,
							  @ModelAttribute("license") LicenseKey licenseKey) {
		Customer customer = licenseKey.getCustomer();
		LicenseType licenseType = licenseKey.getLicenseType();
		
		//todo reformat
		Customer custFromDb = customersService.getCustomerById(customer.getId());
		LicenseType licenseTypeFromDb = licenseTypesService.getLicenseTypeById(licenseType.getId());
		licenseKey.setCustomer(custFromDb);
		licenseKey.setLicenseType(licenseTypeFromDb);
		licenseKey.setAuthor(user);
		licenseKeyService.saveLicenseKey(licenseKey);
		return "redirect:/";
	}

	@PostMapping("/deleteLicense")
	public String  deleteLicense(@RequestParam("licId") int id, Model model) {
		licenseKeyService.deleteLicenseById(id);
		return "redirect:/";
	}
	
}
