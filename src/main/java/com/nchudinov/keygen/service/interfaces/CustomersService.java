package com.nchudinov.keygen.service.interfaces;

import com.nchudinov.keygen.model.Customer;

import java.util.List;

public interface CustomersService {
	
	List<Customer> getAllCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomerById(int id);

	void deleteCustomerId(int id);
}
