package com.anadev.transaction_service.exception;

import com.anadev.transaction_service.database.DTO.TransactionRequest;

public class AccountLimitExceededException extends RuntimeException {

    private final TransactionRequest data;

    public AccountLimitExceededException(String message, TransactionRequest data) {
        super(message);
        this.data = data;
    }

    public TransactionRequest getData(){
        return data;
    }
}
