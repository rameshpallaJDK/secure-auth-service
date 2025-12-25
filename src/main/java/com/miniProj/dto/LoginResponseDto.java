package com.miniProj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {

    private Long userId;
    private String fullName;
    private boolean firstLogin;  // Flag to force password reset
    private String message;
}
