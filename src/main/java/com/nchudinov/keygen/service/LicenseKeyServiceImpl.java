package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.repository.LicenseKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseKeyServiceImpl implements LicenseKeyService {

	@Autowired
	LicenseKeyRepository licenseKeyRepository;
	
	@Override
	public List<LicenseKey> getAllKeys() {
		return licenseKeyRepository.findAll();
	}
}
