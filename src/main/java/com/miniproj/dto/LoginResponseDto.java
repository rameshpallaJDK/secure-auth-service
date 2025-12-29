package com.miniproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginResponseDto {

    private Long userId;
    private String fullName;
    private boolean firstLogin;  // Flag to force password reset
    private String message;
    private QuoteResponseDto quote;
}
