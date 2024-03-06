package com.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeadDto {


	private Long id;
	@NotEmpty(message = "first name can't be empty")
	private String firstName;
	@NotEmpty(message = "last name can't be empty")
	private String lastName;
	@Email(message = "Invalid format of Email")
	private String email;
//	@Pattern(regexp="\\d{10}", message = "Mobile number must be a 10-digit number")
	private Long mobile;
}
