package com.megaandbox.cinema.entity.PayAndBooking;


import com.megaandbox.cinema.entity.code.TicketType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name="booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name="tk_type_id")
    private TicketType ticketType;

    @Column(nullable = false)
    private Integer tkCount;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Integer extraPrice;

    @Column(nullable = false, length = 10)
    private String ageType;
}

