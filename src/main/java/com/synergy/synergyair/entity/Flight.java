package com.synergy.synergyair.entity;

import com.synergy.synergyair.entity.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @OneToOne
    private AirCompany airCompanyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airPlaneId;

    private String departureCountry;

    private String destinationCountry;

    private Float distance;

    private LocalTime estimatedFlightTime;

    private LocalDateTime endedAt;

    private LocalDateTime createdAt;

    private LocalDateTime delayStartedAt;
}
