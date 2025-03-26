package com.davivienda.kata.service.impl;

import com.davivienda.kata.dto.EventRequestDTO;
import com.davivienda.kata.dto.EventResponseDTO;
import com.davivienda.kata.model.Event;
import com.davivienda.kata.repository.EventRepository;
import com.davivienda.kata.service.IEventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements IEventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EventResponseDTO> getAllEvents() {
        return repository.findAll().stream()
                .filter(event -> "ACTIVO".equalsIgnoreCase(event.getStatus()))
                .map(this::toDto)
                .collect(Collectors.toList());

    }


    @Override
    public EventResponseDTO createEvent(EventRequestDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setDate(dto.getDate());
        event.setCapacity(dto.getCapacity());
        event.setReservedCount(0);
        event.setImageBase64(dto.getImageBase64());

        event.setStatus("ACTIVO");

        Event saved = repository.save(event);
        return toDto(saved);
    }



    private EventResponseDTO toDto(Event event) {
        EventResponseDTO dto = new EventResponseDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setDate(event.getDate());
        dto.setCapacity(event.getCapacity());
        dto.setReservedCount(event.getReservedCount());
        dto.setImageBase64(event.getImageBase64());
        dto.setStatus(event.getStatus());
        return dto;
    }


    @Override
    public EventResponseDTO getEventById(Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return toDto(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado para cancelar"));
        event.setStatus("CANCELADO");
        repository.save(event);
    }

    @Override
    public EventResponseDTO updateEvent(Long id, EventRequestDTO dto) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setDate(dto.getDate());
        event.setCapacity(dto.getCapacity());

        if ("CANCELADO".equalsIgnoreCase(event.getStatus())) {
            event.setStatus("ACTIVO");
        }

        if (dto.getImageBase64() != null && !dto.getImageBase64().isBlank()) {
            event.setImageBase64(dto.getImageBase64());
        }

        Event updated = repository.save(event);
        return toDto(updated);
    }

}
