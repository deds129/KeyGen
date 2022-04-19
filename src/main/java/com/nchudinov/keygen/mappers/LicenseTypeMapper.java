package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.LicenseTypeDto;
import com.nchudinov.keygen.model.LicenseType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LicenseTypeMapper {
	LicenseTypeDto toDto(LicenseType licenseType);
	LicenseType toModel(LicenseTypeDto licenseTypeDto);
}
