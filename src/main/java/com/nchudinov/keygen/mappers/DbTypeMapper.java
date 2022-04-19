package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.DbTypeDto;
import com.nchudinov.keygen.model.DbType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DbTypeMapper {
	DbTypeDto toDto(DbType dbType);
	DbType toModel(DbTypeDto dbTypeDto);
}
