package com.miniProj.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProj.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

	//Optional<Country> findById(Long countryId);

}
