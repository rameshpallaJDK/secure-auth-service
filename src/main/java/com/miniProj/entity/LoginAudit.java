package com.miniProj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

//import com.miniProj.entity.User.AccountStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  // optional
@Entity
@Table(name = "login_audit")
public class LoginAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Builder.Default
    private Instant loginTime = Instant.now();

    private String loginStatus; // SUCCESS / FAILED

    private String ipAddress;
    private String userAgent;

    // Getters & Setters
}

