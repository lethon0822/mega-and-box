package com.megaandbox.cinema.entity.movie;

import com.megaandbox.cinema.entity.CreatedAt;
import com.megaandbox.cinema.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"movie_id", "user_id"})
})
public class MovieReview extends CreatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name ="movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name ="user_id")
    private User user;

    @Column(nullable = false)
    private int star;

    @Column(columnDefinition = "TEXT")
    private String review;

    @Column(nullable = false)
    private int like;

}
