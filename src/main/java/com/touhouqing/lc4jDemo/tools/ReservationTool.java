package com.touhouqing.lc4jDemo.tools;

import com.touhouqing.lc4jDemo.pojo.Reservation;
import com.touhouqing.lc4jDemo.service.ReservationService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservationTool {

    @Autowired
    private ReservationService reservationService;

    //1. 添加预约信息
    @Tool("预约志愿填报服务")
    public void addReservation(
        @P("预约人姓名") String name,
        @P("预约人性别") String gender,
        @P("预约人手机号") String phone,
        @P("预约沟通时间,格式为：yyyy-MM-dd'T'HH:MM") LocalDateTime communicationTime,
        @P("考生所在省份") String province,
        @P("考生预估分数") Integer estimatedScore
    ){
        Reservation reservation = new Reservation(null,name,gender,phone,communicationTime,province,estimatedScore);
        reservationService.insert(reservation);
    }

    //2. 查询预约信息
    @Tool("查询预约志愿填报服务")
    public Reservation selectReservation(@P("预约人手机号") String phone){
        return reservationService.selectByPhone(phone);
    }
}
