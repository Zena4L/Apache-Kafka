package com.clement.kafka.controller;

import com.clement.kafka.Message;
import com.clement.kafka.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MessageController {

    private final KafkaTemplate<String, Message> template;

    public MessageController(KafkaTemplate<String, Message> template) {
        this.template = template;
    }

    @PostMapping("/")
    public void publish(@RequestBody MessageRequest request) {
        Message message = new Message(request.message(), LocalDateTime.now());
        template.send("clement", message);
    }
}
