package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.*;
import com.nchudinov.keygen.service.impls.CustomersServiceImpl;
import com.nchudinov.keygen.service.impls.MailSender;
import com.nchudinov.keygen.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
	
	@Autowired
	private MailSender mailSender; 
	
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
		return "licenses_list";
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
		return "license_edit";
	}

	@PostMapping("/updateLicense")
	public String  updateLicense(@RequestParam("licId") int id, Model model) {
		LicenseKey licenseKey = licenseKeyService.getLicenseById(id);
		//must pass attribute with the same name
		if (licenseKey == null) {
			//todo error handling
		}
		model.addAttribute("license", licenseKey);
		return "license_edit";
	}
	
	@PostMapping("/saveLicense")
	public String saveLicense(@AuthenticationPrincipal User user,
							  @Valid @ModelAttribute("license") LicenseKey licenseKey,
							  Errors errors, //always before model
							  Model model) {
		if (errors.hasErrors()) {
			return "license_edit";
		} else {
			
		Customer customer = licenseKey.getCustomer();
		LicenseType licenseType = licenseKey.getLicenseType();
		
		//get entities from db
		Customer custFromDb = customersService.getCustomerById(customer.getId());
		LicenseType licenseTypeFromDb = licenseTypesService.getLicenseTypeById(licenseType.getId());
		
		//add entities to license keys
		licenseKey.setCustomer(custFromDb);
		licenseKey.setLicenseType(licenseTypeFromDb);
		licenseKey.setAuthor(user);
		licenseKeyService.saveLicenseKey(licenseKey);
		}
		return "redirect:/";
	}

	

	@PostMapping("/deleteLicense")
	public String deleteLicense(@RequestParam("licId") int id, Model model) {
		licenseKeyService.deleteLicenseById(id);
		return "redirect:/";
	}

	@PostMapping("/sendKeyByMail")
	public String  sendLicense(@RequestParam("licId") int id, Model model) {
		LicenseKey licenseKey = licenseKeyService.getLicenseById(id);
		if (licenseKey == null) {
			//put error message in model
		}
		
		Customer customer = customersService.getCustomerById(licenseKey.getCustomer().getId());
		
		if (customer == null) {
			//put error message in model
		}
		
		String customerMail =  customer.getCustEmail(); //not null validation on front
		
		if (customerMail != null) {
			String message = String.format(
					"Hello, %s \n" +
							"Thanks for choosing DA Firewall \n" +
							"Your license key: %s",
			customer.getCustName(), licenseKey.getKey());
			
			mailSender.sendMessage(customerMail, "License Key", message);
		}
		//must pass attribute with the same name
		//model.addAttribute("success_message", licenseKey);
		return "redirect:/";
	}
}
