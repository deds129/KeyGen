package com.nchudinov.keygen.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "features", indexes = {
		@Index(name = "features_feature_title_uindex", columnList = "feature_title", unique = true)
})
public class Feature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Lob
	@Column(name = "feature_title", nullable = false)
	private String featureTitle;

	@ManyToMany
	@JoinTable(name = "feature_to_key",
			joinColumns = @JoinColumn(name = "feature_id"),
			inverseJoinColumns = @JoinColumn(name = "key_id"))
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();

	public Set<LicenseKey> getLicenseKeys() {
		return licenseKeys;
	}

	public void setLicenseKeys(Set<LicenseKey> licenseKeys) {
		this.licenseKeys = licenseKeys;
	}

	public String getFeatureTitle() {
		return featureTitle;
	}

	public void setFeatureTitle(String featureTitle) {
		this.featureTitle = featureTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}