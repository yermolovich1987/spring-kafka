package com.dimasco.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListeners {

    @KafkaListener(topics = "simple", groupId = "firstGroup", containerFactory = "firstGroupListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Received Message in group 'dummy': " + message);
    }

    @KafkaListener(topics = "partitioned", groupId = "secondGroup", containerFactory = "secondGroupListenerContainerFactory")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: " + message
                        + "from partition: " + partition);
    }
}
