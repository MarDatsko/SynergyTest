package com.synergy.synergyair.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer factorySerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircompany_id")
    private AirCompany airCompanyId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airPlaneId")
    private List<Flight> numberOfFlights;

    private Float flightDistance;

    private Float fuelCapacity;

    private String type;

    private LocalDate createdAt;
}
