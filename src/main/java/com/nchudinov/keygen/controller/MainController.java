package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.*;
import com.nchudinov.keygen.service.impls.CustomersServiceImpl;
import com.nchudinov.keygen.service.impls.MailSender;
import com.nchudinov.keygen.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
		return showOnePage(searchStr,model,1);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String showOnePage(@RequestParam(required = false) String searchStr, Model model, @PathVariable("pageNumber") int currentPage) {
		
		Page<LicenseKey> licenseKeyPage;
		
		if (searchStr != null && !searchStr.isEmpty()) {
			licenseKeyPage = licenseKeyService.findPageByCustomer(searchStr, currentPage);
		} else {
			licenseKeyPage = licenseKeyService.findPage(currentPage);
		}

		int totalPages = licenseKeyPage.getTotalPages();
		long totalItems = licenseKeyPage.getTotalElements();

		List<LicenseKey> licenseKeys = licenseKeyPage.getContent();

		model.addAttribute("allLicenses", licenseKeys);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		
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
		
		boolean datesError = true;
		if (licenseKey.getStartDate() != null && licenseKey.getEndDate() != null) {
			datesError = licenseKey.getStartDate().after(licenseKey.getEndDate());
			if (datesError) {
				model.addAttribute("datesError","Start date cannot be after end date");
			}
		}
		
		if (errors.hasErrors() || datesError ) {
			model.addAttribute("license",licenseKey);
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteLicense(@RequestParam("licId") int id, Model model) {
		licenseKeyService.deleteLicenseById(id);
		return "redirect:/";
	}

	@PostMapping("/sendKeyByMail")
	public String sendLicense(@RequestParam("licId") int id, Model model) {
		LicenseKey licenseKey = licenseKeyService.getLicenseById(id);
		if (licenseKey == null) {
			//put error message in model
		}

		Customer customer = customersService.getCustomerById(licenseKey.getCustomer().getId());

		if (customer == null) {
			//put error message in model
		}

		String customerMail = customer.getCustEmail(); //not null validation on front

		if (customerMail != null) {
			String message = String.format(
					"Hello, %s \n" +
							"Thanks for choosing DA Firewall \n" +
							"Your license key: %s",
					customer.getCustName(), licenseKey.getKey());

			boolean isMsgSent =  mailSender.sendMessage(customerMail, "License Key", message);
			//todo handle unsuccess mail sending
			String msgStatus;
			if (isMsgSent){
				msgStatus = "success";
			} else {
				msgStatus = "unsuccess";
			}
			model.addAttribute("msg_status", msgStatus);
		}
		
		return "redirect:/";
	}
}
