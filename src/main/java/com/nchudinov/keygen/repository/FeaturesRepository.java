package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.Feature;
import com.nchudinov.keygen.model.OsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturesRepository extends JpaRepository<Integer, Feature> {
}
