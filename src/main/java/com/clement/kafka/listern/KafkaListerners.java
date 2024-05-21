package com.clement.kafka.listern;

import com.clement.kafka.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListerners {

    @KafkaListener(topics = "clement", groupId = "groudId")
    void listener(String data) {
        System.out.println("Listener Received" + " " + data);
    }
}
