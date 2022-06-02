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
	
	@JsonIgnore
	@OneToMany(mappedBy = "licenseType")
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();
}