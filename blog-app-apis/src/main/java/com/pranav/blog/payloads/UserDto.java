package com.pranav.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4 , message = "username must be minimum of 4 characters")
	private String name;
	
	@Email(message = "email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3 , max = 10 , message = "password size must be between 3 to 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}
