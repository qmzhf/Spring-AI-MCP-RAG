package com.chen.product.mcpclient.service;

import org.springframework.ai.chat.model.ChatResponse;
import reactor.core.publisher.Flux;

/**
 * Description: 聊天服务接口
 * @author chen
 * @date 2023/7/13
 */
public interface ChatService {

    /**
     * 聊天接口
     * @param message 消息
     * @return 回复
     */
    String chat(String message);

    /**
     * 流式响应聊天接口
     * @param message 消息
     * @return 回复
     */
    Flux<ChatResponse> streamResponseChat(String message);

    /**
     * 流式响应聊天接口
     * @param message 消息
     * @return 回复
     */
    Flux<String> streamStrChat(String message);
}
