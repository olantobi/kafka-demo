package com.liferon.kafka.service;

import com.liferon.kafka.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "usernames", groupId = "group_id")
    public void consume(User user) {
        System.out.println("Consumed object: "+ user);
    }
}
