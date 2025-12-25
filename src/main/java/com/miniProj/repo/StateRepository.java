package com.miniProj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProj.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{

	List<State> findByCountryCountryId(Long countryId);

}
