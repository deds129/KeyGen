package com.nchudinov.keygen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenseKeyDto implements Serializable {
	private Integer id;
	
	private CustomerDto customer;
	private UserDto author;
	private LicenseTypeDto licenseType;
	
	private String host;
	private Integer port;
	private String key;
	private String comment;
	
	private Date startDate;
	private Date endDate;
	
	private Set<FeatureDto> features;
	private Set<DbTypeDto> dbTypes;
	private Set<OsTypeDto> osTypes;
}
