package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.FeatureDto;
import com.nchudinov.keygen.model.Feature;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FeatureMapper {
	FeatureDto toDto(Feature feature);
	Feature toModel(FeatureDto featureDto);
}
