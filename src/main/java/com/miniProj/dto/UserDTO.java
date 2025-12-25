package com.miniProj.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO {
	private Long userId;
	  private String firstName;
	  private String lastName;
	  private String email;
	  private String mobile;
	  private Long countryId;
	  private Long stateId;
	  private Long cityId;
	  private Boolean passwordResetRequired;
	  private String accountStatus;
	  private String fullName;
	  private String password;
	  private String countryName;
	  private String stateName;
	  private String cityName;
	    
	  private Boolean firstLogin;
}
