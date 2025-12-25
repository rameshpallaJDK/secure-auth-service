package com.miniProj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miniProj.dto.CityDTO;
import com.miniProj.dto.CountryDTO;
import com.miniProj.dto.StateDTO;
import com.miniProj.entity.Country;
import com.miniProj.entity.State;
import com.miniProj.repo.CityRepository;
import com.miniProj.repo.CountryRepository;
import com.miniProj.repo.StateRepository;

@Service
public class MasterDataServiceImp implements MasterDataService {
	
	private final CountryRepository countryRepo;
    private final StateRepository stateRepo;
    private final CityRepository cityRepo;

    public MasterDataServiceImp(CountryRepository countryRepo, StateRepository stateRepo, CityRepository cityRepo) {
        this.countryRepo = countryRepo;
        this.stateRepo = stateRepo;
        this.cityRepo = cityRepo;
    }

	
	@Override
	public List<CountryDTO> getAllCountries() {
		
		List<Country> allCountries = countryRepo.findAll();
				
		List<CountryDTO> countryList = allCountries.stream().map(m->{
			CountryDTO dto=new CountryDTO();
			dto.setCountryId(m.getCountryId());
			dto.setCountryName(m.getCountryName());
			
			return dto;			
		}).collect(Collectors.toList());
		
		return countryList;
		
	}

	@Override
	public List<StateDTO> getStatesByCountry(Long countryId) {
	        return stateRepo.findByCountryCountryId(countryId)
	                .stream()
	                .map(s -> {
	                    StateDTO dto = new StateDTO();
	                    dto.setStateId(s.getStateId());
	                    dto.setStateName(s.getStateName());
	                    return dto;
	                }).collect(Collectors.toList());
	}

	 @Override
	    public List<CityDTO> getCitiesByState(Long stateId) {
	        return cityRepo.findByStateStateId(stateId)
	                .stream()
	                .map(ci -> {
	                    CityDTO dto = new CityDTO();
	                    dto.setCityId(ci.getCityId());
	                    dto.setCityName(ci.getCityName());
	                    return dto;
	                }).collect(Collectors.toList());
	 
	 }
}
