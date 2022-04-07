package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturesRepository extends JpaRepository<Feature, Integer> {
	
	Feature findByFeatureTitle(String title);

	Feature findById(int id);
}
