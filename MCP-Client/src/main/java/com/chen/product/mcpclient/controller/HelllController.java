package com.chen.product.mcpclient.controller;

import com.chen.product.mcpclient.service.ChatService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/hello")
public class HelllController {
    @Resource
    private ChatService chatService;

    @RequestMapping("/world")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/chat")
    public String chat(String message) {
        return chatService.chat(message);
    }

    @RequestMapping("/chat/stream/response")
    public Flux<ChatResponse> streamResponseChat(HttpServletResponse httpResponse,String message) {
        httpResponse.setCharacterEncoding("UTF-8");
        return chatService.streamResponseChat(message);
    }

    @RequestMapping("/chat/stream/str")
    public Flux<String> streamStrChat(HttpServletResponse httpResponse, String message) {
        httpResponse.setCharacterEncoding("UTF-8");
        return chatService.streamStrChat(message);
    }
}
