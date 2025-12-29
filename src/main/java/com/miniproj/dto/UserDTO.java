package com.miniproj.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO {
	  private Long userId;
	  private String email;
	  private String fullName;
      private boolean firstLogin;
      private boolean emailSent;
      private String password;
      private String countryName;
      private String stateName;
      private String cityName;
}
