package com.gabriela.marques.nlw.pass.in.controllers;

import com.gabriela.marques.nlw.pass.in.dto.attendee.AttendeesListResponseDTO;
import com.gabriela.marques.nlw.pass.in.dto.event.EventIdDTO;
import com.gabriela.marques.nlw.pass.in.dto.event.EventRequestDTO;
import com.gabriela.marques.nlw.pass.in.dto.event.EventResponseDTO;
import com.gabriela.marques.nlw.pass.in.services.AttendeeService;
import com.gabriela.marques.nlw.pass.in.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final AttendeeService attendeeService;
    @GetMapping("/{id}")
//    path variable - vai variar
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id) {
        EventResponseDTO event = eventService.getEventDetails(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        EventIdDTO eventDTO = eventService.createEvent(body);
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventDTO.eventId()).toUri();
        return ResponseEntity.created(uri).body(eventDTO);
    }

    @GetMapping("/attendees/{id}")
//    path variable - vai variar
    public ResponseEntity<AttendeesListResponseDTO> getEventAttendees(@PathVariable String id) {
        AttendeesListResponseDTO attendeesList = attendeeService.getEventAttendee(id);
        return ResponseEntity.ok(attendeesList);
    }


}
