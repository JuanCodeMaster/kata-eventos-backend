package com.davivienda.kata.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ReservationRequestDTO {

    @NotNull(message = "El ID del evento es obligatorio")
    private Long eventId;

    @NotNull(message = "El correo del usuario es obligatorio")
    @Email(message = "El correo debe ser válido")
    private String userEmail;
    private String eventStatus;

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    // Getters y Setters

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
