package com.megaandbox.cinema.entity.PayAndBooking;


import com.megaandbox.cinema.configuration.enumCode.model.EnumPaymentStatus;
import com.megaandbox.cinema.configuration.enumCode.model.EnumPaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Column(nullable = false, length = 10)
    private String payMethod;

    @Column(nullable = false)
    private Integer basePrice;

    @Column(nullable = false)
    private Integer finalPrice;

    @Column(nullable = false)
    private Integer discountPrice;

    @Column(nullable = false)
    private LocalDateTime paymentDateDetail;

    @Column(nullable = false)
    private EnumPaymentStatus paymentStatus;

    @Column(nullable = false, length = 150)
    private String pgTid;

    @Column(nullable = false)
    private EnumPaymentType paymentType;
}

