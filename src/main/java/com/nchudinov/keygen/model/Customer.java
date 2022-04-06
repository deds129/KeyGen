package com.nchudinov.keygen.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
	private String сustWebsite;

	@OneToMany(mappedBy = "customer")
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();

	public Set<LicenseKey> getLicenseKeys() {
		return licenseKeys;
	}

	public void setLicenseKeys(Set<LicenseKey> licenseKeys) {
		this.licenseKeys = licenseKeys;
	}

	public String getСustWebsite() {
		return сustWebsite;
	}

	public void setСustWebsite(String сustWebsite) {
		this.сustWebsite = сustWebsite;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}