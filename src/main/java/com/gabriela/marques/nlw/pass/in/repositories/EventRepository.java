package com.gabriela.marques.nlw.pass.in.repositories;

import com.gabriela.marques.nlw.pass.in.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}
