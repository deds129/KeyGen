package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.UserDto;
import com.nchudinov.keygen.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(User user);
	User toModel(UserDto userDto);
}
