package com.synergy.synergyair.service;

import com.synergy.synergyair.entity.AirCompany;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirCompanyService {
    AirCompany getAirCompany(Long id);

    List<AirCompany> getAllAirCompanies();

    void deleteAirCompanyById(Long id);

    void createAirCompany(AirCompany airCompany);

    void updateAirCompany(AirCompany airCompany, Long id);
}
