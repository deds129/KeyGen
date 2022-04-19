package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.OsTypeDto;
import com.nchudinov.keygen.model.OsType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OsTypeMapper {
	OsTypeDto toDto(OsType osType);
	OsType toModel(OsTypeDto osTypeDto);
}
