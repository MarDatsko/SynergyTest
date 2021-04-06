package com.synergy.synergyair.service.impl;

import com.synergy.synergyair.entity.AirCompany;
import com.synergy.synergyair.repository.AirCompanyRepository;
import com.synergy.synergyair.service.AirCompanyService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @SneakyThrows
    @Override
    public AirCompany getAirCompany(Long id) {
        return airCompanyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Air Company with id " + id));
    }

    @Override
    public List<AirCompany> getAllAirCompanies() {
        List<AirCompany> airCompanies = new ArrayList<>();
        airCompanyRepository.findAll().forEach(airCompanies::add);
        return airCompanies;
    }

    @Override
    public void deleteAirCompanyById(Long id) {
        airCompanyRepository.deleteById(id);
    }

    @Override
    public void createAirCompany(AirCompany airCompany) {
        airCompanyRepository.save(airCompany);
    }

    @Override
    public void updateAirCompany(AirCompany airCompany, Long id) {
        airCompany.setId(id);
        airCompanyRepository.save(airCompany);
    }
}
