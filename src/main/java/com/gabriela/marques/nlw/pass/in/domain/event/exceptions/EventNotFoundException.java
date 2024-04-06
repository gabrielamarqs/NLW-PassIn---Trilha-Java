package com.gabriela.marques.nlw.pass.in.domain.event.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String message) {
        super(message);
    }

}
