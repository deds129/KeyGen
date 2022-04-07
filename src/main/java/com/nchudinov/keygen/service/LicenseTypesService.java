package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.LicenseType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LicenseTypesService {

	List<LicenseType> getAllLicenseTypes();

	void saveNewLicenseTypes(LicenseType licenseType);

	LicenseType getLicenseTypeById(int id);

	void deleteLicenseTypeId(int id);
	
}
