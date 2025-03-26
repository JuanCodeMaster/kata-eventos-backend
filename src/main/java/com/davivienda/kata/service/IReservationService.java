package com.davivienda.kata.service;

import com.davivienda.kata.dto.ReservationRequestDTO;
import com.davivienda.kata.dto.ReservationResponseDTO;

import java.util.List;

public interface IReservationService {
    ReservationResponseDTO createReservation(ReservationRequestDTO request);

    List<ReservationResponseDTO> getReservationsByUser(String userEmail);

}
