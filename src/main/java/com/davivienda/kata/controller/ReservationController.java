package com.davivienda.kata.controller;

import com.davivienda.kata.dto.ReservationRequestDTO;
import com.davivienda.kata.dto.ReservationResponseDTO;
import com.davivienda.kata.service.IReservationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationResponseDTO reserve(@Valid @RequestBody ReservationRequestDTO request) {
        return reservationService.createReservation(request);
    }

    @GetMapping("/user/{email}")
    public List<ReservationResponseDTO> getReservationsByUser(@PathVariable String email) {
        return reservationService.getReservationsByUser(email);
    }

}
