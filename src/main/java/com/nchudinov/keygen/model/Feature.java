package com.nchudinov.keygen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "feature_title", nullable = false)
	private String featureTitle;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "feature_to_key",
			joinColumns = @JoinColumn(name = "feature_id"),
			inverseJoinColumns = @JoinColumn(name = "key_id"))
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();
}