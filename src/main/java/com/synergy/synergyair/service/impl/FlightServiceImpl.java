package com.synergy.synergyair.service.impl;

import com.synergy.synergyair.entity.Flight;
import com.synergy.synergyair.entity.dto.FlightCreateDto;
import com.synergy.synergyair.entity.dto.FlightDto;
import com.synergy.synergyair.entity.enums.FlightStatus;
import com.synergy.synergyair.repository.FlightRepository;
import com.synergy.synergyair.service.AirCompanyService;
import com.synergy.synergyair.service.AirplaneService;
import com.synergy.synergyair.service.FlightService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;
    private final ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, AirCompanyService airCompanyService,
                             @Lazy AirplaneService airplaneService, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FlightDto> getAllAirCompanyFlightsByStatus(String status, String companyName) {
        FlightStatus flightStatus = FlightStatus.valueOf(status);

        return flightRepository.findAllByFlightStatus(flightStatus, companyName).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> getAllByFlightStatusAndStartedTime() {
        return flightRepository.findAllByFlightStatusAndStartedTime(FlightStatus.ACTIVE).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findAllById(List<Long> list) {
        List<Flight> flightList = new ArrayList<>();
        flightRepository.findAllById(list).forEach(flightList::add);
        return flightList;
    }

    @Override
    public void addFlight(FlightCreateDto flightCreateDto) {
        Flight flight = modelMapper.map(flightCreateDto, Flight.class);
        flight.setAirCompanyId(airCompanyService.getAirCompany(flightCreateDto.getAirCompanyId()));
        flight.setAirPlaneId(airplaneService.getAirplaneById(flightCreateDto.getAirPlaneId()));
        flightRepository.save(flight);
    }

    @Override
    public void changeStatus(Long id, String status) {
        FlightStatus flightStatus = FlightStatus.valueOf(status);
        Flight flightById = getFlightById(id);
        switch (flightStatus) {
            case COMPLETED:
                flightById.setEndedAt(LocalDateTime.now());
                break;
            case DELAYED:
                flightById.setDelayStartedAt(LocalDateTime.now());
                break;
            case ACTIVE:
                flightById.setCreatedAt(LocalDateTime.now());
                break;
        }
        flightById.setFlightStatus(flightStatus);
        flightRepository.save(flightById);
    }

    @SneakyThrows
    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight with id " + id));
    }

    @Override
    public List<FlightDto> getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate() {
        return flightRepository.getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate(FlightStatus.COMPLETED).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }
}
