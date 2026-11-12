package com.megaandbox.cinema.entity.PayAndBooking;

import com.megaandbox.cinema.entity.CreatedAt;
import com.megaandbox.cinema.entity.code.Seat;
import com.megaandbox.cinema.entity.movie.MovieSchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSeat extends CreatedAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleSeatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "ms_id")
    private MovieSchedule movieSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name="booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "seat_id")
    private Seat seat;

    @Column(nullable = false, length = 5)
    private String seatName;


}
