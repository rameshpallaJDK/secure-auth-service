package com.miniProj.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PasswordResetDto {

    @NotNull(message = "User ID required")
    private Long userId;

    @NotBlank(message = "Old password required")
    private String oldPassword;

    @NotBlank(message = "New password required")
    @Size(min = 6, max = 20, message = "Password must be 6–20 characters")
    private String newPassword;

    @NotBlank(message = "Confirm password required")
    private String confirmPassword;
}

