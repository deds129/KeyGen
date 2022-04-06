package com.nchudinov.keygen.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "db_types", indexes = {
		@Index(name = "db_types_db_title_uindex", columnList = "db_title", unique = true)
})
public class DbType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Lob
	@Column(name = "db_title", nullable = false)
	private String dbTitle;

	@ManyToMany
	@JoinTable(name = "db_to_key",
			joinColumns = @JoinColumn(name = "db_type"),
			inverseJoinColumns = @JoinColumn(name = "key_id"))
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();

	public Set<LicenseKey> getLicenseKeys() {
		return licenseKeys;
	}

	public void setLicenseKeys(Set<LicenseKey> licenseKeys) {
		this.licenseKeys = licenseKeys;
	}

	public String getDbTitle() {
		return dbTitle;
	}

	public void setDbTitle(String dbTitle) {
		this.dbTitle = dbTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}