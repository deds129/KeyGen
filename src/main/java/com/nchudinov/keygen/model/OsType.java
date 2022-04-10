package com.nchudinov.keygen.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "os_types", indexes = {
		@Index(name = "os_types_os_title_uindex", columnList = "os_title", unique = true)
})
public class OsType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "os_title", nullable = false)
	private String osTitle;

	@ManyToMany
	@JoinTable(name = "os_to_key",
			joinColumns = @JoinColumn(name = "os_id"),
			inverseJoinColumns = @JoinColumn(name = "key_id"))
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();

	public Set<LicenseKey> getLicenseKeys() {
		return licenseKeys;
	}

	public void setLicenseKeys(Set<LicenseKey> licenseKeys) {
		this.licenseKeys = licenseKeys;
	}

	public String getOsTitle() {
		return osTitle;
	}

	public void setOsTitle(String osTitle) {
		this.osTitle = osTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}