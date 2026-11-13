package com.megaandbox.cinema.entity.coupon;

import com.megaandbox.cinema.entity.PayAndBooking.Payment;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CouponUsedLog {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "payment_id")
    private Payment payment;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "cp_id")
    private UserCoupon cp;

}
