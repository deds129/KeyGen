package com.nchudinov.keygen.model;

import javax.persistence.*;


@Entity
@Table(name = "license_keys")
public class LicenseKey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;


	@Column(name = "customer")
	private String customer;

	@Column(name = "license_type")
	private String licenseType;

	@Column(name = "host")
	private String host;

	@Column(name = "port")
	private Integer port;

	@Column(name = "os")
	private String operSystem;
	
	@Column(name = "lic_key")
	private String key;

	public LicenseKey() {
	}

	public LicenseKey(Integer id, String customer, String licenseType, String host, Integer port, String operSystem, String key) {
		this.id = id;
		this.customer = customer;
		this.licenseType = licenseType;
		this.host = host;
		this.port = port;
		this.operSystem = operSystem;
		this.key = key;
	}

	public LicenseKey(String customer, String licenseType, String host, Integer port, String operSystem, String key) {
		this.customer = customer;
		this.licenseType = licenseType;
		this.host = host;
		this.port = port;
		this.operSystem = operSystem;
		this.key = key;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getOperSystem() {
		return operSystem;
	}

	public void setOperSystem(String operSystem) {
		this.operSystem = operSystem;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "LicenseKey{" +
				"id=" + id +
				", customer='" + customer + '\'' +
				", licenseType='" + licenseType + '\'' +
				", host='" + host + '\'' +
				", port=" + port +
				", operSystem='" + operSystem + '\'' +
				", key='" + key + '\'' +
				'}';
	}
}
