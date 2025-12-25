package com.miniProj.entity;

//package com.miniProj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
//import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  // optional

@Entity
@Table(name = "email_log")
public class EmailLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    private String recipient;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String sentStatus; // QUEUED / SENT / FAILED

    private Instant sentAt;
    
    @Builder.Default
    private Integer retryCount = 0;

    // Getters & Setters
}
