package com.anadev.transaction_service.database.DTO;

import com.anadev.transaction_service.database.collection.Transaction;
import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TransactionRequest(
        Long accountId,
        Long userId,
        String userEmail,
        TypeTransaction type,
        BigDecimal value,
        TypeCategory category,
        String description)
{
    public Transaction toTransaction(){
        return Transaction.builder()
                .accountId(this.accountId)
                .userId(this.userId)
                .userEmail(this.userEmail)
                .type(this.type)
                .value(this.value)
                .category(this.category)
                .description(this.description)
                .build();
    }
}
