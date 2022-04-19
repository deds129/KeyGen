package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.model.Feature;
import com.nchudinov.keygen.repository.FeaturesRepository;
import com.nchudinov.keygen.service.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturesServiceImpl implements FeaturesService {
	
	@Autowired
	private FeaturesRepository featuresRepository;
	
	@Override
	public List<Feature> getAllFeatures() {
		return featuresRepository.findAll();
	}

	@Override
	public void saveNewFeature(Feature feature) {
		featuresRepository.save(feature);
	}

	@Override
	public Feature getFeatureById(int id) {
		return featuresRepository.findById(id);
	}

	@Override
	public void deleteFeatureId(int id) {
		featuresRepository.deleteById(id);
	}
}
