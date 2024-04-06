package com.gabriela.marques.nlw.pass.in.config;

import com.gabriela.marques.nlw.pass.in.domain.event.exceptions.EventNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// vai tratar as exceções da controller
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException notFound){
        return ResponseEntity.notFound().build();
    }
}
