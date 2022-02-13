package com.nchudinov.keygen.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "license_keys")
public class LicenseKey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;


	@Column(name = "customer", length = 50)
	private String customer;

	@Column(name = "license_type", nullable = false, length = 50)
	private String licenseType;

	@Column(name = "host", nullable = false, length = 50)
	private String host;

	@Column(name = "port")
	private Integer port;

	@Column(name = "oper_system", nullable = false, length = 20)
	private String operSystem;
	
	@Column(name = "key", nullable = false)
	private String key;

	public LicenseKey(String customer, String licenseType, String host, Integer port, String operSystem, String key) {
		this.customer = customer;
		this.licenseType = licenseType;
		this.host = host;
		this.port = port;
		this.operSystem = operSystem;
		this.key = key;
	}
}
