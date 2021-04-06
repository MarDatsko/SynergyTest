package com.synergy.synergyair.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.synergy.synergyair.entity.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private FlightStatus flightStatus;
    private AirCompanyDto airCompanyId;
    private String departureCountry;
    private String destinationCountry;
    private Float distance;
    private LocalTime estimatedFlightTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endedAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime delayStartedAt;
}
