package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.model.LicenseType;
import com.nchudinov.keygen.repository.LicenseTypesRepository;
import com.nchudinov.keygen.service.LicenseTypesService;
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
		return licenseTypesRepository.getById(id);
	}

	@Override
	public void deleteLicenseTypeId(int id) {
		licenseTypesRepository.deleteById(id);
	}
}
