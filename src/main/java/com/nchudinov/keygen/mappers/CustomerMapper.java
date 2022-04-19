package com.nchudinov.keygen.mappers;

import com.nchudinov.keygen.dto.CustomerDto;
import com.nchudinov.keygen.model.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {
	
	CustomerDto toDto(Customer customer);
	Customer toModel(CustomerDto customerDto);
}
