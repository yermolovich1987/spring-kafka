package com.dimasco.demo.listener;

import com.dimasco.demo.dto.CustomMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListeners {

    @KafkaListener(topics = "simple", groupId = "firstGroup", containerFactory = "firstGroupListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Received Message from simple topic: " + message);
    }

    @KafkaListener(topics = "partitioned", groupId = "secondGroup", containerFactory = "secondGroupListenerContainerFactory")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: " + message
                        + "from partition: " + partition);
    }

    @KafkaListener(topics = "custom", groupId = "customMessage", containerFactory = "customMessageListenerContainerFactory")
    public void listenWithHeaders(CustomMessage customMessage) {
        System.out.println("Received custom message: " + customMessage);
    }
}
