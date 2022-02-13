package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.repository.LicenseKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
