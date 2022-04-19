package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.DbTypeDto;
import com.nchudinov.keygen.model.DbType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = DbTypeMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DbTypeSetMapper {
	Set<DbType> toModelList(Set<DbTypeDto> dtos);
	Set<DbTypeDto> toDTOList(Set<DbType> models);
}
