package com.gabriela.marques.nlw.pass.in.repositories;

import com.gabriela.marques.nlw.pass.in.domain.checkin.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<CheckIn, String> {
}
