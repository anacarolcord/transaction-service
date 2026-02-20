package com.anadev.transaction_service.messaging.rabbit;

import com.anadev.transaction_service.database.DTO.TransactionRequest;
import com.anadev.transaction_service.database.DTO.TransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarningLimitProducer {

    private final StreamBridge streamBridge;
    private final ObjectMapper objectMapper;

    public WarningLimitProducer(StreamBridge streamBridge, ObjectMapper objectMapper) {
        this.streamBridge = streamBridge;
        this.objectMapper = objectMapper;
    }

    public void publish(TransactionRequest data){
//        String warningEvent = "Tentativa de compra negada, o valor excede seu limite atual";
        String payload;

        try {
             payload = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        streamBridge.send("warning-limit-out-0",payload);
    }


}
