package com.synergy.synergyair.service.impl;

import com.synergy.synergyair.entity.Airplane;
import com.synergy.synergyair.entity.dto.AirplaneCreateDto;
import com.synergy.synergyair.repository.AirplaneRepository;
import com.synergy.synergyair.service.AirCompanyService;
import com.synergy.synergyair.service.AirplaneService;
import com.synergy.synergyair.service.FlightService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyService airCompanyService;
    private final FlightService flightService;
    private final ModelMapper modelMapper;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository, AirCompanyService airCompanyService,
                               FlightService flightService, ModelMapper modelMapper) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
        this.flightService = flightService;
        this.modelMapper = modelMapper;
    }

    @SneakyThrows
    @Override
    public Airplane getAirplaneById(Long id) {
        return airplaneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Airplane with id " + id));
    }

    @Override
    public void moveAirplaneBetweenCompany(Long id, Long companyId) {
        Airplane airplane = getAirplaneById(id);
        airplane.setAirCompanyId(airCompanyService.getAirCompany(companyId));
        airplaneRepository.save(airplane);
    }

    @Override
    public void addAirplane(AirplaneCreateDto airplaneCreateDto) {
        Airplane airplane = modelMapper.map(airplaneCreateDto, Airplane.class);
        airplane.setAirCompanyId(airCompanyService.getAirCompany(airplaneCreateDto.getAirCompanyId()));
        airplaneRepository.save(airplane);
    }
}
