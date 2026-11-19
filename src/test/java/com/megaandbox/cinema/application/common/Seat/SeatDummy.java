package com.megaandbox.cinema.application.common.Seat;

import com.megaandbox.cinema.application.JpaDummy;
import com.megaandbox.cinema.application.common.auditorium.AuditoriumRepository;
import com.megaandbox.cinema.application.common.seat.SeatRepository;
import com.megaandbox.cinema.configuration.enumCode.model.movie.EnumSeatType;
import com.megaandbox.cinema.entity.code.Auditorium;
import com.megaandbox.cinema.entity.code.Seat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


public class SeatDummy extends JpaDummy {
    @Autowired
    SeatRepository seatRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Test
    @Rollback(false) // 더미 데이터 저장을 위해 롤백하지 않음
    void saveSeat() {

        List<Auditorium> auditoriums = auditoriumRepository.findAll();

        for (Auditorium auditorium : auditoriums) {
            for (char line = 'A'; line <= 'H'; line++) {
                for (int number = 1; number <= 9; number++) {

                    EnumSeatType seatType = EnumSeatType.NORMAL;

                    if (line == 'G' || line == 'H') {
                        if (number <= 3) {
                            seatType = EnumSeatType.SPECIAL;
                        }
                    }

                    if (number >= 7) {
                        seatType = EnumSeatType.DISABLED;
                    }

                    Seat seat = Seat.builder()
                            .auditorium(auditorium)
                            .seatLine(String.valueOf(line))
                            .seatNumber(String.valueOf(number))
                            .seatType(seatType)
                            .build();

                    seatRepository.save(seat);
                }
            }
        }
    }
}
