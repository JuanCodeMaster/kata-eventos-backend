package com.davivienda.kata.controller;

import com.davivienda.kata.dto.EventRequestDTO;
import com.davivienda.kata.dto.EventResponseDTO;
import com.davivienda.kata.service.IEventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final IEventService service;

    public EventController(IEventService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventResponseDTO> getEvents() {
        return service.getAllEvents();
    }

    @PostMapping
    public EventResponseDTO createEvent(@Valid @RequestBody EventRequestDTO dto) {
        return service.createEvent(dto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Long id) {
        EventResponseDTO event = service.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public EventResponseDTO updateEvent(@PathVariable Long id, @RequestBody EventRequestDTO dto) {
        return service.updateEvent(id, dto);
    }

}
