package com.anadev.transaction_service.messaging.rabbit;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarningLimitProducer {

    private final StreamBridge streamBridge;

    public WarningLimitProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void publish(){
        String warningEvent = "Tentativa de compra negada, o valor excede seu limite atual";

        streamBridge.send("warning-limit-out-0", warningEvent);
    }


}
