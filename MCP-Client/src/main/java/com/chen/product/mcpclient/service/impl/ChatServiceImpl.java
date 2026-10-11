package com.chen.product.mcpclient.service.impl;

import com.chen.product.mcpclient.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Description: 聊天服务实现类
 *
 * @author chen
 * @date 2023/7/13
 */
@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    private String systemPrompt = """
            你是您的个人助手,你很聪明，我为你取了一个名字Jadodo.""";

    /**
     * 构造函数
     * @param chatClientBuilder chatClientBuilder
     */
    /**
     * 提示词三大类型
     * 1.系统提示词 System Prompt
     *
     */
    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem(systemPrompt).build();
    }
    /**
     * 聊天接口
     * @param message 消息
     * @return 回复
     */
    @Override
    public String chat(String message) {
        return chatClient.prompt(message).call().content();
    }

    /**
     * 流式响应聊天接口
     *
     * @param message 消息
     * @return 回复
     */
    @Override
    public Flux<ChatResponse> streamResponseChat(String message) {
        return chatClient.prompt(message).stream().chatResponse();
    }

    /**
     * 流式响应聊天接口
     *
     * @param message 消息
     * @return 回复
     */
    @Override
    public Flux<String> streamStrChat(String message) {
        return chatClient.prompt(message).stream().content();
    }
}
