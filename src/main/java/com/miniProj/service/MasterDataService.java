package com.miniProj.service;

import java.util.List;

import com.miniProj.dto.CityDTO;
import com.miniProj.dto.CountryDTO;
import com.miniProj.dto.StateDTO;

public interface MasterDataService {
	
	List<CountryDTO> getAllCountries();

    List<StateDTO> getStatesByCountry(Long countryId);

    List<CityDTO> getCitiesByState(Long stateId);

}
