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
@Table(name = "db_types", indexes = {
		@Index(name = "db_types_db_title_uindex", columnList = "db_title", unique = true)
})
public class DbType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "db_title", nullable = false)
	private String dbTitle;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "db_to_key",
			joinColumns = @JoinColumn(name = "db_type"),
			inverseJoinColumns = @JoinColumn(name = "key_id"))
	private Set<LicenseKey> licenseKeys = new LinkedHashSet<>();
}