package com.liferon.kafka.resource;

import com.liferon.kafka.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class UserResource {

    private final KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "usernames";

    @PostMapping("publish")
    public ResponseEntity<?> post(@RequestBody User user) {
        kafkaTemplate.send(TOPIC, user);

        return ResponseEntity.ok("Published Successfully");
    }
}
