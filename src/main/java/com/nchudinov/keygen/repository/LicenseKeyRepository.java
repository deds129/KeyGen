package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.LicenseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LicenseKeyRepository extends JpaRepository<LicenseKey, Integer> {
	List<LicenseKey> findLicenseKeyByCustomerCustName(String customerName);
}
