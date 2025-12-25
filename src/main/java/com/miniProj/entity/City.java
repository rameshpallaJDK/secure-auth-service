package com.miniProj.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  // optional

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @Column(nullable = false, length = 100)
    private String cityName;
    
    @Builder.Default
    private Boolean isActive = true;
    
    @Builder.Default
    private Instant createdAt = Instant.now();
    @Builder.Default
    private Instant updatedAt = Instant.now();

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<User> users;

    @PreUpdate
    public void preUpdate() { updatedAt = Instant.now(); }

    // getters & setters
}

