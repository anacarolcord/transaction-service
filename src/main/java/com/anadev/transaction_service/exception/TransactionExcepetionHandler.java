package com.anadev.transaction_service.exception;

import com.anadev.transaction_service.messaging.rabbit.WarningLimitProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionExcepetionHandler {

    private final WarningLimitProducer warningLimitProducer;

    public TransactionExcepetionHandler(WarningLimitProducer warningLimitProducer) {
        this.warningLimitProducer = warningLimitProducer;
    }

    @ExceptionHandler(AccountLimitExceededException.class)
    public ResponseEntity<String> handleLimitExceeded(AccountLimitExceededException ex){

        warningLimitProducer.publish();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }
}