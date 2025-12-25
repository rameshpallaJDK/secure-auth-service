package com.miniProj.entity;
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
@Table(name = "quote_cache")
public class QuoteCache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String quoteText;

    private String author;
    @Builder.Default
    private Instant fetchedAt = Instant.now();
    @Builder.Default
    private Boolean isActive = true;

    // Getters & Setters
}
