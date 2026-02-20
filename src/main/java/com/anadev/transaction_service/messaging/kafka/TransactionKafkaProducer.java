package com.anadev.transaction_service.messaging.kafka;

import com.anadev.transaction_service.database.DTO.TransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import java.math.BigDecimal;

@Configuration
public class TransactionKafkaProducer {

    public final KafkaTemplate <String,String> kafkaTemplate;
    public static final String TOPIC = "transaction-topic";
    private final ObjectMapper objectMapper;

    public TransactionKafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(TransactionResponse data){

        String payload = null;
        try {
            payload = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        this.kafkaTemplate.send(TOPIC,payload );
    }
}
