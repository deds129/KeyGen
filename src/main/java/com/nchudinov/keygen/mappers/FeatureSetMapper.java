package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.FeatureDto;
import com.nchudinov.keygen.model.Feature;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = FeatureMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FeatureSetMapper {
	Set<Feature> toModelList(Set<FeatureDto> dtos);
	Set<FeatureDto> toDTOList(Set<Feature> models);
}
