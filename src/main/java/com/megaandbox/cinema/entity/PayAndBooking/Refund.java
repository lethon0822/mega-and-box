package com.megaandbox.cinema.entity.PayAndBooking;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;

    @OneToOne
    @JoinColumn(nullable = false, unique = true, name="payment_id")
    private Payment payment;

    @Column(nullable = false)
    private int refundPrice;

    @Column(nullable = false)
    private LocalDateTime refundDate;
}
