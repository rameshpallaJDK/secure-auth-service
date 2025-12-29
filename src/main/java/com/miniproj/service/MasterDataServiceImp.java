package com.miniproj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miniproj.dto.CityDTO;
import com.miniproj.dto.CountryDTO;
import com.miniproj.dto.StateDTO;
import com.miniproj.entity.Country;
import com.miniproj.repo.CityRepository;
import com.miniproj.repo.CountryRepository;
import com.miniproj.repo.StateRepository;

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

        return allCountries.stream().map(m->{
            CountryDTO dto=new CountryDTO();
            dto.setCountryId(m.getCountryId());
            dto.setCountryName(m.getCountryName());

            return dto;
        }).collect(Collectors.toList());
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
