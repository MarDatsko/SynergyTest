package com.synergy.synergyair.controller;

import com.synergy.synergyair.entity.AirCompany;
import com.synergy.synergyair.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircompanies")
public class AirCompanyController {

    private final AirCompanyService airCompanyService;

    @Autowired
    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @GetMapping("/{id}")
    public AirCompany getAirCompany(@PathVariable("id") Long id) {
        return airCompanyService.getAirCompany(id);
    }

    @GetMapping
    public List<AirCompany> getAllAirCompanies() {
        return airCompanyService.getAllAirCompanies();
    }

    @DeleteMapping("/{id}")
    public void deleteAirCompanyById(@PathVariable("id") Long id) {
        airCompanyService.deleteAirCompanyById(id);
    }

    @PostMapping
    public void createAirCompany(@RequestBody AirCompany airCompany) {
        airCompanyService.createAirCompany(airCompany);
    }

    @PutMapping("/{id}")
    public void updateAirCompany(@PathVariable("id") Long id, @RequestBody AirCompany airCompany) {
        airCompanyService.updateAirCompany(airCompany, id);
    }
}
