package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Customer;
import com.nchudinov.keygen.service.interfaces.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping("/customers")
	private String customerList(Model model) {
		model.addAttribute("customers", customersService.getAllCustomers());
		return "customers_list";
	}

	@GetMapping("/customers/{custId}")
	private String editCustomer(@PathVariable("custId") int id, Model model ){
		//todo add norm handling
		Customer customer = customersService.getCustomerById(id);
		if (customer == null) {
			model.addAttribute("error", "user not found!");
		}
		model.addAttribute("customer", customer );
		return "customer_edit";
	}

	@GetMapping("/customers/addCustomer")
	private String addCustomer(Model model ){
		//todo add norm handling
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer_edit";
	}
	
	@PostMapping("/saveCustomer")
	private String updateCustomer(@ModelAttribute("customer") Customer customer) {
		customersService.saveCustomer(customer);
		return "redirect:/customers";
	}

	//delete customer using GET request
	@GetMapping("customers/deleteCustomer/{custId}")
	public String  deleteCustomer(@PathVariable("custId") int id, Model model ) {
		customersService.deleteCustomerId(id);
		return "redirect:/customers";
	}
	
	
}
