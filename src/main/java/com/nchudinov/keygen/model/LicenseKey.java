package com.nchudinov.keygen.model;

import javax.persistence.*;

@Entity
@Table(name = "license_keys")
public class LicenseKey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "customer")
	private String customer;
	
	//todo: add Author(in db), Client, LicenseType(Enum), OS(Enum), Type(Enum), StartDate, EndDate, Key(String),
}
