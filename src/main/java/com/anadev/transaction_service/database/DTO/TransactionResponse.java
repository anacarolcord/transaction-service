package com.anadev.transaction_service.database.DTO;

import com.anadev.transaction_service.database.collection.Transaction;
import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse (
        ObjectId id,
        Long accountId,
        Long userId,
        TypeTransaction type,
        BigDecimal value,
        TypeCategory category,
        LocalDateTime occurredAt,
        String description
) {
    public static TransactionResponse fromTransaction(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getAccountId(),
                transaction.getUserId(),
                transaction.getType(),
                transaction.getValue(),
                transaction.getCategory(),
                transaction.getOccurredAt(),
                transaction.getDescription()
        );
    }
}
