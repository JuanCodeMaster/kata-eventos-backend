package com.davivienda.kata.dto;

public class ReservationResponseDTO {

    private Long id;
    private String userEmail;
    private String eventName;
    private String eventStatus; // 👈 NUEVO

    // Constructor completo
    public ReservationResponseDTO(Long id, String userEmail, String eventName, String eventStatus) {
        this.id = id;
        this.userEmail = userEmail;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
}
