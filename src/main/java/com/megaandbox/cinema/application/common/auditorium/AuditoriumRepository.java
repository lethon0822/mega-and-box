package com.megaandbox.cinema.application.common.auditorium;

import com.megaandbox.cinema.entity.code.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
