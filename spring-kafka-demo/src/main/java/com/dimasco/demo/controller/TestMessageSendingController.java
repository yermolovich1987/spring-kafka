package com.dimasco.demo.controller;

import com.dimasco.demo.dto.CustomMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Simple controller that allows to send messages to the specific topic.
 */
@AllArgsConstructor
@RestController
public class TestMessageSendingController {

    private KafkaTemplate<String, String> simpleKafkaTemplate;
    private KafkaTemplate<String, CustomMessage> advancedKafkaTemplate;

    @GetMapping("/send")
    public String sendMessageToTopic(@RequestParam(name = "topic") String topicName,
                                     @RequestParam(name = "message") String message)
            throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("Sending message to topic: " + topicName);

        SendResult<String, String> sendResult = simpleKafkaTemplate.send(topicName, message).get(3, TimeUnit.SECONDS);

        System.out.println(String.format("Message to topic %s is successfully sent.  Response: %s",
                topicName,
                sendResult.toString()));

        return "Message sent";
    }

    @GetMapping("/send-custom")
    public String sendCustomMessageToTopic(@RequestParam(name = "topic") String topicName,
                                     @RequestParam(name = "message") String message)
            throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("Sending message to topic: " + topicName);

        CustomMessage customMessage = new CustomMessage(1l, message);
        SendResult<String, CustomMessage> sendResult = advancedKafkaTemplate.send(topicName, customMessage)
                .get(3, TimeUnit.SECONDS);

        System.out.println(String.format("Message to topic %s is successfully sent.  Response: %s",
                topicName,
                sendResult.toString()));

        return "Message sent";
    }

}
