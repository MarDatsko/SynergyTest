package com.synergy.synergyair.entity.dto;

import com.synergy.synergyair.entity.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightCreateDto {
    private FlightStatus flightStatus;
    private Long airCompanyId;
    private Long airPlaneId;
    private String departureCountry;
    private String destinationCountry;
    private Float distance;
    private LocalTime estimatedFlightTime;
    private LocalDateTime endedAt;
    private LocalDateTime createdAt;
    private LocalDateTime delayStartedAt;
}