package com.megaandbox.cinema.application.common.seat;

import com.megaandbox.cinema.entity.code.Seat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SeatRepository extends JpaRepository<Seat,Long> {
}
