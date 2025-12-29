package com.miniproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproj.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{


}
