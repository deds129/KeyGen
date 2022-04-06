package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.LicenseType;
import com.nchudinov.keygen.model.OsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseTypesRepository extends JpaRepository<Integer, LicenseType> {
}
