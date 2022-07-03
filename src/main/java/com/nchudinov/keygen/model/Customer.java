package com.nchudinov.keygen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "cust_name")
	@NotBlank(message = "Customer name cannot be empty")
	private String custName;

	@Email
	@NotBlank(message = "Customer email cannot be empty")
	@Column(name = "cust_email")
	private String custEmail;

	@NotBlank(message = "Customer phone number cannot be empty")
	@Length(min = 10, max = 11, message = "Phone number must be at least 11 characters long")
	@Column(name = "cust_phone")
	private String custPhone;
	
	@Column(name = "сust_website")
	private String custWebsite;

	@NotBlank(message = "Customer company name cannot be empty")
	@Column(name = "company_name")
	private String custCompName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();
	
}