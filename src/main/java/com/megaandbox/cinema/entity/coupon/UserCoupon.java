package com.megaandbox.cinema.entity.coupon;

import com.megaandbox.cinema.configuration.enumCode.model.user.EnumCouponStatus;
import com.megaandbox.cinema.entity.CreatedAt;
import com.megaandbox.cinema.entity.UpdatedAt;
import com.megaandbox.cinema.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@EqualsAndHashCode
public class UserCoupon extends CreatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ucId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @Column
    private LocalDateTime usedAt;

    @Column(nullable = false, length = 10)
    private String cpType;

    @Column(nullable = false)
    private EnumCouponStatus cpStatus;

}