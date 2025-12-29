package com.miniproj.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miniproj.dto.CityDTO;
import com.miniproj.dto.CountryDTO;
import com.miniproj.dto.StateDTO;
import com.miniproj.service.MasterDataServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class MasterDataController {

    private final MasterDataServiceImp masterService;

    public MasterDataController(MasterDataServiceImp masterService) {
        this.masterService = masterService;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDTO>> getCountries() {
        return ResponseEntity.ok(masterService.getAllCountries());
    }

    @GetMapping("/states/{countryId}")
    public ResponseEntity<List<StateDTO>> getStates(@PathVariable Long countryId) {
        return ResponseEntity.ok(masterService.getStatesByCountry(countryId));
    }

    @GetMapping("/cities/{stateId}")
    public ResponseEntity<List<CityDTO>> getCities(@PathVariable Long stateId) {
        return ResponseEntity.ok(masterService.getCitiesByState(stateId));
    }
}

