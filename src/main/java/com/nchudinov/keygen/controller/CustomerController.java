package com.nchudinov.keygen.controller;

import com.nchudinov.keygen.model.Customer;
import com.nchudinov.keygen.service.interfaces.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping("/customers")
	public String customerList(Model model) {
		model.addAttribute("customers", customersService.getAllCustomers());
		return "customers_list";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/customers/{custId}")
	public String editCustomer(@PathVariable("custId") int id, Model model ){
		//todo add norm handling
		Customer customer = customersService.getCustomerById(id);
		if (customer == null) {
			model.addAttribute("error", "User not found!");
		}
		model.addAttribute("customer", customer );
		return "customer_edit";
	}

	@GetMapping("/customers/addCustomer")
	public String addCustomer(Model model ){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer_edit";
	}
	
	@PostMapping("/saveCustomer")
	public String updateCustomer(@ModelAttribute("customer") @Valid Customer customer, Errors errors, Model model) {
		
		if (errors != null && errors.hasErrors()) {
			return "customer_edit";
		}
		customersService.saveCustomer(customer);
		return "redirect:/customers";
	}

	//delete customer using GET request
	@PreAuthorize("hasRole('ROLE_ADMIN')") // - it cause npl???
	@GetMapping("customers/deleteCustomer/{custId}")
	public String  deleteCustomer(@PathVariable("custId") int id, Model model ) {
		customersService.deleteCustomerId(id);
		return "redirect:/customers";
	}
	
	
}
