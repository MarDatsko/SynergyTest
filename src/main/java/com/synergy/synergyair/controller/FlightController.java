package com.synergy.synergyair.controller;

import com.synergy.synergyair.entity.dto.FlightCreateDto;
import com.synergy.synergyair.entity.dto.FlightDto;
import com.synergy.synergyair.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/status")
    public List<FlightDto> getAllAirCompanyFlightsByStatus(@RequestParam String status,
                                                           @RequestParam String companyName) {
        return flightService.getAllAirCompanyFlightsByStatus(status, companyName);
    }

    @GetMapping("/active")
    public List<FlightDto> getAllByFlightStatusAndStartedTime() {
        return flightService.getAllByFlightStatusAndStartedTime();
    }

    @PostMapping
    public void addFlight(@RequestBody FlightCreateDto flightCreateDto) {
        flightService.addFlight(flightCreateDto);
    }

    @PatchMapping("/{id}/status")
    public void changeStatus(@PathVariable Long id, @RequestParam String status) {
        flightService.changeStatus(id, status);
    }

    @GetMapping("/completed/bigger-then-estimate")
    public List<FlightDto> getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate() {
        return flightService.getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate();
    }
}
