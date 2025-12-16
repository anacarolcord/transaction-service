package com.anadev.transaction_service.database.DTO;

import com.anadev.transaction_service.database.collection.Transaction;
import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import lombok.Builder;

@Builder
public record TransactionRequest(
        Long accountId,
        Long userId,
        TypeTransaction type,
        Double amount,
        TypeCategory category,
        String description)
{
    public Transaction toTransaction(){
        return Transaction.builder()
                .accountId(this.accountId)
                .userId(this.userId)
                .type(this.type)
                .amount(this.amount)
                .category(this.category)
                .description(this.description)
                .build();
    }
}
