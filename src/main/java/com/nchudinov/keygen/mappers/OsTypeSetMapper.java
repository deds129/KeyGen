package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.OsTypeDto;
import com.nchudinov.keygen.model.OsType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = OsTypeMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OsTypeSetMapper {
	Set<OsType> toModelList(Set<OsTypeDto> dtos);
	Set<OsTypeDto> toDTOList(Set<OsType> models);
}
