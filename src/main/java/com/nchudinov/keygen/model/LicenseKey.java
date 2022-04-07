package com.nchudinov.keygen.model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "license_keys")
public class LicenseKey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	//customer one element;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer")
	private Customer customer;
	
	@Column(name = "host")
	private String host;

	@Column(name = "port")
	private Integer port;
	
	@Column(name = "lic_key")
	private String key;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usr_id")
	private User author;
	
	@Column(name = "lic_comment")
	private String comment;
	
	@Column(name ="start_date")
	private Date startDate;

	@Column(name ="end_date")
	private Date endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_type")
	private LicenseType licenseType;

	public LicenseKey() {
	}

	public LicenseKey(Integer id, Customer customer, String host, Integer port, String key, User author, String comment, Date startDate, Date endDate, LicenseType licenseType, Set<Feature> features, Set<DbType> dbTypes, Set<OsType> osTypes) {
		this.id = id;
		this.customer = customer;
		this.host = host;
		this.port = port;
		this.key = key;
		this.author = author;
		this.comment = comment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.licenseType = licenseType;
		this.features = features;
		this.dbTypes = dbTypes;
		this.osTypes = osTypes;
	}

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

	public Set<OsType> getOsTypes() {
		return osTypes;
	}

	public void setOsTypes(Set<OsType> osTypes) {
		this.osTypes = osTypes;
	}
	
	public Set<DbType> getDbTypes() {
		return dbTypes;
	}

	public void setDbTypes(Set<DbType> dbTypes) {
		this.dbTypes = dbTypes;
	}
	
	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LicenseType getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
