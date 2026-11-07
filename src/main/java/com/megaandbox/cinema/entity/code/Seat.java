package com.megaandbox.cinema.entity.code;

import com.megaandbox.cinema.configuration.enumCode.model.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id", nullable = false)
    private Auditorium auditorium;

    @Column(nullable = false, length = 1, columnDefinition = "CHAR(1)")
    private String seatLine;

    @Column(nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String seatNumber;

    @Column(nullable = false)
    private SeatType seatType;
}
