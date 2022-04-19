package com.nchudinov.keygen.dto;

import com.nchudinov.keygen.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto implements Serializable {
	private Long id;
	private String username;
	private String password;
	private boolean active;
	private String email;
	private String phoneNumber;
	private String activationCode;
	
	private Set<Role> roles;
}
