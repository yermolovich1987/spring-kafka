package com.dimasco.avrodemo.producer;

import com.dimasco.avrodemo.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleProducer {
  private final String topicName;
  private final KafkaTemplate<String, DummyMessage> kafkaTemplate;

  @Autowired
  public SampleProducer(@Value("${app.kafka.topic}")String topicName,
                        KafkaTemplate<String, DummyMessage> kafkaTemplate) {
    this.topicName = topicName;
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    log.info("#### -> Producing message -> {}", message);
    this.kafkaTemplate.send(topicName, new DummyMessage(message, 12));
  }
}
