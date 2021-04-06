package com.synergy.synergyair.service;

import com.synergy.synergyair.entity.Airplane;
import com.synergy.synergyair.entity.dto.AirplaneCreateDto;
import org.springframework.stereotype.Service;

@Service
public interface AirplaneService {
    void moveAirplaneBetweenCompany(Long id, Long companyId);

    void addAirplane(AirplaneCreateDto airplaneCreateDto);

    Airplane getAirplaneById(Long id);
}
