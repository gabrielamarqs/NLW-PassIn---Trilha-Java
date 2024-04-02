package com.gabriela.marques.nlw.pass.in.repositories;

import com.gabriela.marques.nlw.pass.in.domain.attendee.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, String>{
}
