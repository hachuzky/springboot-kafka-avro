package com.sunilvb.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sunilvb.demo.Order;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

  @KafkaListener(
      topics = "#{'${topic.name}'}",
      groupId = "simple-consumer"
  )
  public void consume(Order order) {
    log.info(String.format("Consumed message -> %s", order));
  }
}