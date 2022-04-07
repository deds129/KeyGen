package com.nchudinov.keygen.service;

import com.nchudinov.keygen.model.Feature;

import java.util.List;

public interface FeaturesService {

	List<Feature> getAllFeatures();

	public void saveNewFeature(Feature Feature);

	Feature getFeatureById(int id);

	void deleteFeatureId(int id);
}
