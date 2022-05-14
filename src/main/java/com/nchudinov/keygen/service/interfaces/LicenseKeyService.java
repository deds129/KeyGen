package com.nchudinov.keygen.service.interfaces;

import com.nchudinov.keygen.model.LicenseKey;

import java.util.List;

public interface LicenseKeyService {
	List<LicenseKey> getAllKeys();

	void saveLicenseKey(LicenseKey licenseKey);
	
	LicenseKey getLicenseById(int id);
	
	void deleteLicenseById(int id);

	List<LicenseKey> getKeysByCustomer(String customerName);
}
