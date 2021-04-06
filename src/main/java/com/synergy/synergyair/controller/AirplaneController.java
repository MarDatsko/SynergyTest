package com.synergy.synergyair.controller;

import com.synergy.synergyair.entity.dto.AirplaneCreateDto;
import com.synergy.synergyair.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PatchMapping("/{id}")
    public void moveAirplaneBetweenCompany(@PathVariable("id") Long id, @RequestParam Long companyId) {
        airplaneService.moveAirplaneBetweenCompany(id, companyId);
    }

    @PostMapping()
    public void addAirplane(@RequestBody AirplaneCreateDto airplaneCreateDto) {
        airplaneService.addAirplane(airplaneCreateDto);
    }
}
