package com.synergy.synergyair.repository;

import com.synergy.synergyair.entity.Flight;
import com.synergy.synergyair.entity.enums.FlightStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Query(value = "FROM Flight f JOIN AirCompany air ON f.airCompanyId = air.id " +
            "WHERE f.flightStatus =:flightStatus AND air.name=:companyName")
    List<Flight> findAllByFlightStatus(FlightStatus flightStatus, String companyName);

    @Query(value = "SELECT * FROM synergy.flight WHERE flight_status = :flightStatus " +
            "AND TO_DAYS(NOW()) - TO_DAYS(created_at) <= 1", nativeQuery = true)
    List<Flight> findAllByFlightStatusAndStartedTime(FlightStatus flightStatus);

    @Query(value = "SELECT * FROM synergy.flight WHERE flight_status = :flightStatus " +
            "AND TIMEDIFF(ended_at,created_at) > estimated_flight_time", nativeQuery = true)
    List<Flight> getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate(FlightStatus flightStatus);
}
