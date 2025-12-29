package com.miniproj.repo;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.miniproj.dto.CityDTO;
import com.miniproj.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

	Collection<CityDTO> findByStateStateId(Long stateId);

}
