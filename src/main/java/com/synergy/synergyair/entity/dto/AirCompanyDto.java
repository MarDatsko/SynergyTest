package com.synergy.synergyair.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCompanyDto {
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
