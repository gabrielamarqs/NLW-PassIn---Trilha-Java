package com.gabriela.marques.nlw.pass.in.dto.event;

public record EventRequestDTO(
        String title,
        String details,
        Integer maximumAttendees
) {
}
