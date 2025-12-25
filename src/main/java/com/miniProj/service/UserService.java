package com.miniProj.service;

import com.miniProj.dto.LoginRequestDto;
import com.miniProj.dto.LoginResponseDto;
import com.miniProj.dto.PasswordResetDto;
import com.miniProj.dto.UserCreateDTO;
import com.miniProj.dto.UserDTO;

public interface UserService {
	
	  UserDTO registerUser(UserCreateDTO dto);
	  UserDTO getUserById(Long id);
	  //void resetPassword(Long userId, String oldPassword, String newPassword);
	  void forceResetPassword(Long userId, String newPassword);
	  LoginResponseDto login(LoginRequestDto dto);
	  
	  String resetPassword(PasswordResetDto dto);

	
	

}
