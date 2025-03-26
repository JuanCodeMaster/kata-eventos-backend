package com.davivienda.kata.repository;

import com.davivienda.kata.dto.ReservationResponseDTO;
import com.davivienda.kata.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT new com.davivienda.kata.dto.ReservationResponseDTO(r.id, r.userEmail, e.name, e.status) " +
            "FROM Reservation r JOIN r.event e WHERE r.userEmail = :email")
    List<ReservationResponseDTO> findDtoByUserEmail(@Param("email") String email);


}
