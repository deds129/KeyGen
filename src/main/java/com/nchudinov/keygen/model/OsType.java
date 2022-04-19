package com.nchudinov.keygen.model;

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
	
}