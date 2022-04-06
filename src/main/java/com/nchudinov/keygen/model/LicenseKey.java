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
	@JoinColumn(name = "customer_id")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer")
	private Customer customer1;

	@Column(name = "os")
	private String os;

	@ManyToMany
	@JoinTable(name = "feature_to_key",
			joinColumns = @JoinColumn(name = "key_id"),
			inverseJoinColumns = @JoinColumn(name = "feature_id"))
	private Set<Feature> features = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "licenseKeys")
	private Set<OsType> osTypes = new LinkedHashSet<>();

	@ManyToMany
	@JoinTable(name = "db_to_key",
			joinColumns = @JoinColumn(name = "key_id"),
			inverseJoinColumns = @JoinColumn(name = "db_type"))
	private Set<DbType> dbTypes = new LinkedHashSet<>();

	public Set<DbType> getDbTypes() {
		return dbTypes;
	}

	public void setDbTypes(Set<DbType> dbTypes) {
		this.dbTypes = dbTypes;
	}

	public Set<OsType> getOsTypes() {
		return osTypes;
	}

	public void setOsTypes(Set<OsType> osTypes) {
		this.osTypes = osTypes;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Customer getCustomer1() {
		return customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}

	public LicenseKey() {
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	//os type (many elements)
	
	//features (many elements)
	

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
