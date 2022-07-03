package com.nchudinov.keygen.controller.rest;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.service.interfaces.CustomersService;
import com.nchudinov.keygen.service.interfaces.LicenseKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LicenseKeyRestController {
	
	@Autowired
	private CustomersService customersService;

	@Autowired
	private LicenseKeyService licenseKeyService;

	@GetMapping("/lic_keys")
	public List<LicenseKey> getLicenseKeyList() {
		return licenseKeyService.getAllKeys();
	}
	
	
}
