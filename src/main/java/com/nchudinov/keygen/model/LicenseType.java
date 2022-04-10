package com.nchudinov.keygen.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "license_types", indexes = {
		@Index(name = "license_types_type_title_uindex", columnList = "type_title", unique = true)
})
public class LicenseType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "type_title", nullable = false)
	private String typeTitle;

	@OneToMany(mappedBy = "licenseType")
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();

	public Set<LicenseKey> getLicenseKeys() {
		return licenseKeys;
	}

	public void setLicenseKeys(Set<LicenseKey> licenseKeys) {
		this.licenseKeys = licenseKeys;
	}

	public String getTypeTitle() {
		return typeTitle;
	}

	public void setTypeTitle(String typeTitle) {
		this.typeTitle = typeTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}