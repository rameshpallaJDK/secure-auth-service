package com.miniproj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproj.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{

	List<State> findByCountryCountryId(Long countryId);

}
