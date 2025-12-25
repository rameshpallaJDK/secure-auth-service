package com.miniProj.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserCreateDTO {
	  @NotBlank
	  private String firstName;
	  private String lastName;
	  @NotBlank
	  @Email
	  private String email;
	  private String mobile;
	  private Long countryId;
	  private Long stateId;
	  private Long cityId;
	  private String countryName;
	  private String stateName;
	  private String cityName;
	    
	  private Boolean firstLogin;

}
