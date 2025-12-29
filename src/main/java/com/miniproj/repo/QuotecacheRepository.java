package com.miniproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproj.entity.QuoteCache;

public interface QuotecacheRepository extends JpaRepository<QuoteCache, Long> {

}
