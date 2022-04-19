package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.LicenseKeyDto;
import com.nchudinov.keygen.model.LicenseKey;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
	uses = {CustomerMapper.class, UserMapper.class, LicenseTypeMapper.class, FeatureSetMapper.class, DbTypeSetMapper.class, OsTypeSetMapper.class},
		injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LicenseKeyMapper {
	LicenseKeyDto toDto(LicenseKey licenseKey); 
	LicenseKey toModel(LicenseKeyDto licenseKeyDto);
	
	/*
	@Mappings({
      @Mapping(target="employeeId", source="entity.id"),
      @Mapping(target="employeeName", source="entity.name")
    })
    EmployeeDTO employeeToEmployeeDTO(Employee entity);
    @Mappings({
      @Mapping(target="id", source="dto.employeeId"),
      @Mapping(target="name", source="dto.employeeName")
    })
    Employee employeeDTOtoEmployee(EmployeeDTO dto);
	 */
}
