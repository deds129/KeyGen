package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.handlers.KeyGenerator;
import com.nchudinov.keygen.model.LicenseKey;
import com.nchudinov.keygen.repository.LicenseKeyRepository;
import com.nchudinov.keygen.service.interfaces.LicenseKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
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
	public Page<LicenseKey> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1,5);
		return licenseKeyRepository.findAll(pageable);
	}

	@Override
	public Page<LicenseKey> findPageByCustomer(String customerName, int pageNumber ) {
		Pageable pageable = PageRequest.of(pageNumber - 1,5);
		return licenseKeyRepository.findPageByCustomerCustName(customerName, pageable);
	}

	@Override
	public void saveLicenseKey(LicenseKey licenseKey) {
		//generate unique key to entity
		
		//just server date now
		licenseKey.setUpdateDate(new Date());
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
