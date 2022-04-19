package com.nchudinov.keygen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto implements Serializable {
	private Integer id;
	private String custName;
	private String custEmail;
	private String custPhone;
	private String custWebsite;
}
