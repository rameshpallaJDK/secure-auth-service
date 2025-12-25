package com.miniProj.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
//import java.util.List;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  // optional

@Entity
@Table(name = "password_history")
public class PasswordHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String oldPasswordHash;
    
    @Builder.Default
    private Instant changedAt = Instant.now();

    //public PasswordHistory() {}

    public PasswordHistory(User user, String oldPasswordHash) {
        this.user = user;
        this.oldPasswordHash = oldPasswordHash;
    }

    // Getters & Setters
}

