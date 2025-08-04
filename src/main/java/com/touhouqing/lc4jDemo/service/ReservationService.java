package com.touhouqing.lc4jDemo.service;

import com.touhouqing.lc4jDemo.mapper.ReservationMapper;
import com.touhouqing.lc4jDemo.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    //添加预约信息
    public void insert(Reservation reservation){
        reservationMapper.insert(reservation);
    }
    //根据手机号查询预约信息
    public Reservation selectByPhone(String phone){
        return reservationMapper.selectByPhone(phone);
    }

}
