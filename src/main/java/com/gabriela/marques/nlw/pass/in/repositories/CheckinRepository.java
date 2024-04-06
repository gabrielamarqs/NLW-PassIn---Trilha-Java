package com.gabriela.marques.nlw.pass.in.repositories;

import com.gabriela.marques.nlw.pass.in.domain.checkin.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckinRepository extends JpaRepository<CheckIn, String> {
    Optional<CheckIn> findByAttendeeId(String attendeeId);
}
