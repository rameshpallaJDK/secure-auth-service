package com.miniProj.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProj.dto.CityDTO;
//import com.miniProj.dto.CountryDTO;
import com.miniProj.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

	Collection<CityDTO> findByStateStateId(Long stateId);

}
