package com.dimasco.avrodemo.consumer;

import com.dimasco.avrodemo.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleListener {

  @KafkaListener(topics = "${app.kafka.topic}")
  public void listen(DummyMessage message) {
    log.info("$$$$$   Message received: {}", message);
  }
}
