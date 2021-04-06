package com.synergy.synergyair.service;

import com.synergy.synergyair.entity.Flight;
import com.synergy.synergyair.entity.dto.FlightCreateDto;
import com.synergy.synergyair.entity.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    List<FlightDto> getAllAirCompanyFlightsByStatus(String status, String companyName);

    List<FlightDto> getAllByFlightStatusAndStartedTime();

    List<Flight> findAllById(List<Long> list);

    void addFlight(FlightCreateDto flightCreateDto);

    void changeStatus(Long id, String status);

    Flight getFlightById(Long id);

    List<FlightDto> getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate();
}
