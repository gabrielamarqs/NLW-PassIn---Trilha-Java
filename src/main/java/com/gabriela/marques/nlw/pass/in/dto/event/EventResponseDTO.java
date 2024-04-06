package com.gabriela.marques.nlw.pass.in.dto.event;

import com.gabriela.marques.nlw.pass.in.domain.event.Event;
import lombok.Data;

@Data
public class EventResponseDTO {
    EventDetailDTO event;

//    está pegando os dados do evento para mostrar na resposta
    public EventResponseDTO(Event event, Integer numberOfAttendees) {
        this.event = new EventDetailDTO(event.getId(), event.getTitle(), event.getDetails(), event.getSlug(), event.getMaximumAttendees(), numberOfAttendees);
    }
}
