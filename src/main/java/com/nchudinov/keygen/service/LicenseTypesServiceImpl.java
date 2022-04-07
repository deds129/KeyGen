package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.LicenseType;
import com.nchudinov.keygen.repository.LicenseKeyRepository;
import com.nchudinov.keygen.repository.LicenseTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseTypesServiceImpl implements LicenseTypesService {
	
	@Autowired
	private LicenseTypesRepository licenseTypesRepository;
	
	@Override
	public List<LicenseType> getAllLicenseTypes() {
		return licenseTypesRepository.findAll();
	}

	@Override
	public void saveNewLicenseTypes(LicenseType licenseType) {
		licenseTypesRepository.save(licenseType);
	}

	@Override
	public LicenseType getLicenseTypeById(int id) {
		return null;
	}

	@Override
	public void deleteLicenseTypeId(int id) {
		licenseTypesRepository.deleteById(id);
	}
}
