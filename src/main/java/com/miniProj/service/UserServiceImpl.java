package com.miniProj.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

//import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.servlet.support.RequestContext;

import com.miniProj.dto.*;
import com.miniProj.entity.*;
import com.miniProj.exception.InvalidRequestException;
import com.miniProj.exception.ResourceNotFoundException;
import com.miniProj.repo.*;
import com.miniProj.util.RequestContext;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final CountryRepository countryRepo;
    private final StateRepository stateRepo;
    private final CityRepository cityRepo;
    private final PasswordHistoryRepository passwordHistoryRepo;
    private final PasswordEncoder passwordEncoder;
    private final LoginAuditRepository loginAuditRepo;

    // ----------------------------------------------------------------------
    // USER REGISTRATION
    // ----------------------------------------------------------------------
    @Override
    public UserDTO registerUser(UserCreateDTO dto) {

        if (userRepo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Generate random password
        String rawPwd = RandomPasswordGenerator.generate(12);
        String hashed = passwordEncoder.encode(rawPwd);

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());

        user.setPassword(hashed);
        user.setPasswordResetRequired(true);
        user.setFirstLogin(true);

        // Fetch location
        user.setCountry(countryRepo.findById(dto.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Country", "id", dto.getCountryId())));

        user.setState(stateRepo.findById(dto.getStateId())
                .orElseThrow(() -> new ResourceNotFoundException("State", "id", dto.getStateId())));

        user.setCity(cityRepo.findById(dto.getCityId())
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", dto.getCityId())));

        userRepo.save(user);

        // Response DTO
        return UserDTO.builder()
                .userId(user.getUserId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(rawPwd)                 // return random pwd
                .countryName(user.getCountry().getCountryName())
                .stateName(user.getState().getStateName())
                .cityName(user.getCity().getCityName())
                .firstLogin(true)
                .build();
    }

    // ----------------------------------------------------------------------
    // LOGIN
    // ----------------------------------------------------------------------
    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidRequestException("Invalid email or password");
        }
        boolean passwordCorrect = passwordEncoder.matches(dto.getPassword(), user.getPassword());
        
        
        String status = passwordCorrect ? "SUCCESS" : "FAILED";
     // Create audit entry
        LoginAudit audit = LoginAudit.builder()
                .user(user)
                .loginStatus(status)
                .ipAddress(RequestContext.getClientIP())
                .userAgent(RequestContext.getUserAgent())
                .build();

        loginAuditRepo.save(audit);


        if (user.getFirstLogin()) {
            return new LoginResponseDto(
                    user.getUserId(),
                    user.getFullName(),
                    true,
                    "Password reset required"
            );
        }

        return new LoginResponseDto(
                user.getUserId(),
                user.getFullName(),
                false,
                "Login successful"
        );
    }

    // ----------------------------------------------------------------------
    // RESET PASSWORD (SELF)
    // ----------------------------------------------------------------------
    @Override
    @Transactional
    public String resetPassword(PasswordResetDto dto) {

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new InvalidRequestException("Old password does not match");
        }

        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            throw new InvalidRequestException("New password & confirm password mismatch");
        }

        // Check last 3 password history
        List<PasswordHistory> history = passwordHistoryRepo.findTop3ByUserOrderByChangedAtDesc(user);

        for (PasswordHistory h : history) {
            if (passwordEncoder.matches(dto.getNewPassword(), h.getOldPasswordHash())) {
                throw new InvalidRequestException("Cannot reuse last 3 passwords");
            }
        }

        // Save old pwd to history
        passwordHistoryRepo.save(
                new PasswordHistory(user, user.getPassword())
        );

        // Update password
        String newHash = passwordEncoder.encode(dto.getNewPassword());
        user.setPassword(newHash);
        user.setFirstLogin(false);
        user.setUpdatedAt(Instant.now());
        userRepo.save(user);

        return "Password changed successfully";
    }

    // ----------------------------------------------------------------------
    // ADMIN FORCED RESET
    // ----------------------------------------------------------------------
    @Override
    @Transactional
    public void forceResetPassword(Long userId, String newPassword) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String hashed = passwordEncoder.encode(newPassword);

        user.setPassword(hashed);
        user.setPasswordResetRequired(false);
        user.setFirstLogin(false);
        userRepo.save(user);

        passwordHistoryRepo.save(new PasswordHistory(user, hashed));
    }

    // ----------------------------------------------------------------------
    @Override
    public UserDTO getUserById(Long id) {
        throw new UnsupportedOperationException("Implement later");
    }

	
}
