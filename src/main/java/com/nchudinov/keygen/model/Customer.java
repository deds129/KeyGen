package com.nchudinov.keygen.model;

import lombok.*;

import javax.persistence.*;
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
	private String custName;
	
	@Column(name = "cust_email")
	private String custEmail;
	
	@Column(name = "cust_phone")
	private String custPhone;
	
	@Column(name = "сust_website")
	private String custWebsite;

	@OneToMany(mappedBy = "customer")
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();
	
}