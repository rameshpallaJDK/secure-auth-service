package com.miniProj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniProj.dto.PasswordResetDto;
import com.miniProj.dto.UserCreateDTO;
import com.miniProj.dto.UserDTO;
import com.miniProj.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserCreateDTO dto) {
        UserDTO createdUser = userService.registerUser(dto);
        return ResponseEntity.ok(createdUser);
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody PasswordResetDto dto) {
        return ResponseEntity.ok(userService.resetPassword(dto));
    }

}