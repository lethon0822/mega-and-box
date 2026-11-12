package com.megaandbox.cinema.entity.membershipAndEvent;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false, length = 30)
    private String eventName;

    @Column(nullable = false)
    private LocalDate eventStart;

    @Column
    private LocalDate eventEnd;

    @Column(nullable = false, length = 200)
    private String eventImage;

    @Column(nullable = false)
    private boolean isJoin;
}
