package com.nchudinov.keygen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "license_type")
	private LicenseType licenseType;
	
	@Column(name = "host")
	private String host;

	@Column(name = "port")
	private Integer port;
	
	@Column(name = "lic_key")
	private String key;
	
	@Column(name = "lic_comment")
	private String comment;
	
	@Column(name ="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;

	@Column(name ="end_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "feature_to_key",
			joinColumns = @JoinColumn(name = "key_id"),
			inverseJoinColumns = @JoinColumn(name = "feature_id"))
	private Set<Feature> features = new LinkedHashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "db_to_key",
			joinColumns = @JoinColumn(name = "key_id"),
			inverseJoinColumns = @JoinColumn(name = "db_type"))
	private Set<DbType> dbTypes = new LinkedHashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "os_to_key",
	joinColumns = @JoinColumn(name = "os_id"),
	inverseJoinColumns =  @JoinColumn(name = "key_id"))
	private Set<OsType> osTypes = new LinkedHashSet<>();
	
	//todo refactor
	public Set<String> getFeaturesTitles(){
		Set<String> featuresTitleSet;
		featuresTitleSet = features.stream().map(Feature::getFeatureTitle).collect(Collectors.toSet());
		return featuresTitleSet;
	}

	public Set<String> getOsTitles(){
		Set<String> OsTitleSet;
		OsTitleSet = osTypes.stream().map(OsType::getOsTitle).collect(Collectors.toSet());
		return OsTitleSet;
	}

	@Override
	public String toString() {
		return "LicenseKey{" +
				"customer=" + customer.getCustName() +
				", licenseType=" + licenseType.getTypeTitle() +
				", host='" + host + '\'' +
				", port=" + port +
				", comment='" + comment + '\'' +
				", startDate='" + new SimpleDateFormat("yyyy-mm-dd").format(startDate) + '\'' +
				", endDate='" +  new SimpleDateFormat("yyyy-mm-dd").format(endDate) + '\'' +
				", features=" + Arrays.toString(features.stream().map(Feature::getFeatureTitle).toArray()) +
				", dbTypes=" + Arrays.toString(dbTypes.stream().map(DbType::getDbTitle).toArray()) +
				", osTypes=" + Arrays.toString(osTypes.stream().map(OsType::getOsTitle).toArray()) +
				'}';
	}
}
