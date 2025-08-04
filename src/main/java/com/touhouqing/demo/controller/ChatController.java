package com.touhouqing.demo.controller;

import com.touhouqing.demo.aiservice.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    @Autowired
    private ConsultantService consultantService;

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String message){
        Flux<String> result = consultantService.chat(message);
        return  result;
    }
//    @RequestMapping("/chat")
//    public String chat(String message){
//        String result = consultantService.chat(message);
//        return  result;
//    }
}
