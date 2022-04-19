package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.handlers.KeyGenerator;
import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.repository.LicenseKeyRepository;
import com.nchudinov.keygen.service.LicenseKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseKeyServiceImpl implements LicenseKeyService {

	@Autowired
	private LicenseKeyRepository licenseKeyRepository;
	
	@Override
	public List<LicenseKey> getAllKeys() {
		return licenseKeyRepository.findAll();
	}

	@Override
	public void saveLicenseKey(LicenseKey licenseKey) {
		//generate unique key to entity
		licenseKey.setKey(KeyGenerator.generateKey(licenseKey));
		licenseKeyRepository.save(licenseKey);
	}

	@Override
	public LicenseKey getLicenseById(int id) {
		return licenseKeyRepository.getById(id);
	}

	@Override
	public void deleteLicenseById(int id) {
		licenseKeyRepository.deleteById(id);
	}

	@Override
	public List<LicenseKey> getKeysByCustomer(String customerName) {
		return licenseKeyRepository.findLicenseKeyByCustomerCustName(customerName);
	}
}