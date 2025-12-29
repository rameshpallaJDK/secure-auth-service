package com.miniproj.service;

import com.miniproj.dto.LoginRequestDto;
import com.miniproj.dto.LoginResponseDto;
import com.miniproj.dto.PasswordResetDto;
import com.miniproj.dto.UserCreateDTO;
import com.miniproj.dto.UserDTO;

public interface UserService {
	
	  UserDTO registerUser(UserCreateDTO dto);
	  UserDTO getUserById(Long id);
	  //void resetPassword(Long userId, String oldPassword, String newPassword);
	  void forceResetPassword(Long userId, String newPassword);
	  LoginResponseDto login(LoginRequestDto dto);
	  
	  String resetPassword(PasswordResetDto dto);

	
	

}
