package com.touhouqing.demo.aiservice;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel"//流式模型
)
public interface ConsultantService {
    //聊天
    //public String chat(String message);
    //@UserMessage("你是神，{{it}}")
    @SystemMessage(fromResource = "/system.txt")
    public Flux<String> chat(String message);
}
