package com.gabriela.marques.nlw.pass.in.services;

import com.gabriela.marques.nlw.pass.in.domain.attendee.Attendee;
import com.gabriela.marques.nlw.pass.in.domain.event.Event;
import com.gabriela.marques.nlw.pass.in.domain.event.exceptions.EventNotFoundException;
import com.gabriela.marques.nlw.pass.in.dto.event.EventIdDTO;
import com.gabriela.marques.nlw.pass.in.dto.event.EventRequestDTO;
import com.gabriela.marques.nlw.pass.in.dto.event.EventResponseDTO;
import com.gabriela.marques.nlw.pass.in.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private final EventRepository eventRepository;
    private final AttendeeService attendeeService;


    public EventResponseDTO getEventDetails(String eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + eventId));
        List<Attendee> attendeeList = this.attendeeService.getAllAttendeesFromEvent(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }

    public EventIdDTO createEvent(EventRequestDTO eventDTO) {
        Event newEvent = new Event();
        newEvent.setTitle(eventDTO.title());
        newEvent.setDetails(eventDTO.details());
        newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
        newEvent.setSlug(this.createSlug(eventDTO.title()));

        return new EventIdDTO(newEvent.getId());
    }

    private String createSlug(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized
//                vai selecionar os acentos da frase e substituir por string vazia
                .replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "")
//                seleciona todos os caracteres q não sao alfa numericos e substitui por uma string vazia
                .replaceAll("[^\\w\\s]", "")
//                substitui espaço vazio por hifen
                .replaceAll("\\s+", "-")
                .toLowerCase();
    }

}
