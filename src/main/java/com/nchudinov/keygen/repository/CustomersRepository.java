package com.nchudinov.keygen.repository;

import com.nchudinov.keygen.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {
	
}
