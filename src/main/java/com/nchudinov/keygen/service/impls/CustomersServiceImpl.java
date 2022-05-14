package com.nchudinov.keygen.service.impls;

import com.nchudinov.keygen.mappers.CustomerMapper;
import com.nchudinov.keygen.model.Customer;
import com.nchudinov.keygen.repository.CustomersRepository;
import com.nchudinov.keygen.service.interfaces.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
	
	@Autowired
	private CustomersRepository customersRepository;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customersRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customersRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customersRepository.getById(id);
	}

	@Override
	public void deleteCustomerId(int id) {
		customersRepository.deleteById(id);
	}
}
