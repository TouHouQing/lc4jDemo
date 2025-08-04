package com.touhouqing.lc4jDemo;

import com.touhouqing.lc4jDemo.pojo.Reservation;
import com.touhouqing.lc4jDemo.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ReservationServiceTest {
    @Autowired
    private ReservationService reservationService;

    @Test
    void testInsert(){
        Reservation reservation = new Reservation(null, "张三", "男", "13800000000", LocalDateTime.now(), "北京市", 5);
        reservationService.insert(reservation);
    }
}
