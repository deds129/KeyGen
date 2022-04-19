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
public class LicenseTypeDto implements Serializable {
	private Integer id;
	private String typeTitle;
}
