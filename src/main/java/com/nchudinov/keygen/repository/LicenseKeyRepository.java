package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.LicenseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseKeyRepository extends JpaRepository<LicenseKey, Integer> {
}
