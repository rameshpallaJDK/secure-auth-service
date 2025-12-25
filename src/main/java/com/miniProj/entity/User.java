package com.miniProj.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  // optional

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long userId;

  private String firstName;
  private String lastName;

  @Column(nullable=false, unique=true)
  private String email;

  private String mobile;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  private Country country;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "state_id")
  private State state;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "city_id")
  private City city;

  @Column(name="password_hash")
  private String password;

  
  @Builder.Default
  private Boolean passwordResetRequired = Boolean.TRUE;

  @Enumerated(EnumType.STRING)
  @Builder.Default
  private AccountStatus accountStatus = AccountStatus.PENDING;
  @Builder.Default
  private Integer failedLoginAttempts = 0;
  private Instant lastLoginAt;
  @Builder.Default
  private Instant createdAt = Instant.now();
  @Builder.Default
  private Instant updatedAt = Instant.now();

  // getters & setters omitted for brevity

  public enum AccountStatus {
    ACTIVE, INACTIVE, LOCKED, PENDING
  }

  @PreUpdate
  public void preUpdate() { updatedAt = Instant.now(); }

  @Column(name = "first_login", nullable = false)
  @Builder.Default
  private Boolean firstLogin = Boolean.TRUE;

  @Transactional
  public String getFullName() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
  }
}
