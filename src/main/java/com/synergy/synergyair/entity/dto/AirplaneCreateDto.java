package com.synergy.synergyair.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneCreateDto {
    private String name;
    private Integer factorySerialNumber;
    private Long airCompanyId;
    private Float flightDistance;
    private Float fuelCapacity;
    private String type;
    private LocalDate createdAt;
}
