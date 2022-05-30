package com.nchudinov.keygen.service.interfaces;

import com.nchudinov.keygen.model.LicenseKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LicenseKeyService {

	Page<LicenseKey> findPage(int pageNumber);

	Page<LicenseKey> findPageByCustomer(String customerName, int pageNumber);
	
	List<LicenseKey> getAllKeys();

	void saveLicenseKey(LicenseKey licenseKey);
	
	LicenseKey getLicenseById(int id);
	
	void deleteLicenseById(int id);

	List<LicenseKey> getKeysByCustomer(String customerName);
}
