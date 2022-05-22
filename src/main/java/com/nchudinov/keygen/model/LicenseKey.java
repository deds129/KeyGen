package com.nchudinov.keygen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "license_keys")
public class LicenseKey {
	
	//todo add fileds validation
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "usr_id")
	private User author;

	@NotNull(message = "Field cannot be empty")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "license_type")
	private LicenseType licenseType;

	@NotBlank(message = "Field has not to be blank")
	@Column(name = "host")
	private String host;

	@Min(value = 0, message = "Min value is 1")
	@Max(value = 65535, message = "Max value is 65535")
	@Column(name = "port")
	private Integer port;
	
	@Column(name = "lic_key", length = 2048)
	private String key;
	
	@Column(name = "lic_comment")
	@Length(max = 2048, message = "Comment too long")
	private String comment;
	
	@Column(name ="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;

	@Column(name ="end_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@NotEmpty(message = "Choose at least one option")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "feature_to_key",
			joinColumns = @JoinColumn(name = "key_id"),
			inverseJoinColumns = @JoinColumn(name = "feature_id"))
	private Set<Feature> features = new LinkedHashSet<>();

	@NotEmpty(message = "Choose at least one option")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "db_to_key",
			joinColumns = @JoinColumn(name = "key_id"),
			inverseJoinColumns = @JoinColumn(name = "db_type"))
	private Set<DbType> dbTypes = new LinkedHashSet<>();

	@NotEmpty(message = "Choose at least one option")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "os_to_key",
	joinColumns = @JoinColumn(name = "key_id"),
	inverseJoinColumns =  @JoinColumn(name = "os_id"))
	private Set<OsType> osTypes = new LinkedHashSet<>();
	
	//todo refactor
	public Set<String> getFeaturesTitles(){
		return features.stream().map(Feature::getFeatureTitle).collect(Collectors.toSet());
	}

	public Set<String> getOsTitles(){
		return osTypes.stream().map(OsType::getOsTitle).collect(Collectors.toSet());
	}

	public Set<String> getDbTypeTitles(){
		return dbTypes.stream().map(DbType::getDbTitle).collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return "LicenseKey{" +
				"customer=" + customer.getCustName() +
				", licenseType=" + licenseType.getTypeTitle() +
				", host='" + host + '\'' +
				", port=" + port +
				", comment='" + comment + '\'' +
				", startDate='" + (startDate == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(startDate) ) + '\'' +
				", endDate='" + (endDate == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(endDate)) + '\'' +
				", features=" + Arrays.toString(features.stream().map(Feature::getFeatureTitle).toArray()) +
				", dbTypes=" + Arrays.toString(dbTypes.stream().map(DbType::getDbTitle).toArray()) +
				", osTypes=" + Arrays.toString(osTypes.stream().map(OsType::getOsTitle).toArray()) +
				'}';
	}
}
