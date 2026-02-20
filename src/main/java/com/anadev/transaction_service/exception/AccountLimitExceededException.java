package com.anadev.transaction_service.exception;

public class AccountLimitExceededException extends RuntimeException {
    public AccountLimitExceededException(String message) {
        super(message);
    }
}
