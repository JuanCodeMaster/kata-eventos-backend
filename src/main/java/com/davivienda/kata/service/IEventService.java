package com.davivienda.kata.service;

import com.davivienda.kata.dto.EventRequestDTO;
import com.davivienda.kata.dto.EventResponseDTO;

import java.util.List;

public interface IEventService {
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO createEvent(EventRequestDTO dto);
    EventResponseDTO getEventById(Long id);
    void deleteEvent(Long id);
    EventResponseDTO updateEvent(Long id, EventRequestDTO dto);


}
