package com.miniproj.service;

import java.util.List;

import com.miniproj.dto.CityDTO;
import com.miniproj.dto.CountryDTO;
import com.miniproj.dto.StateDTO;

public interface MasterDataService {
	
	List<CountryDTO> getAllCountries();

    List<StateDTO> getStatesByCountry(Long countryId);

    List<CityDTO> getCitiesByState(Long stateId);

}
