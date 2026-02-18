package com.anadev.transaction_service.client.dto;

import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import lombok.Builder;
import org.bson.types.ObjectId;


import java.math.BigDecimal;

@Builder
public record TransactionRequestDTO(
        Long accountId,
        BigDecimal value,
        TypeTransaction typeTransaction)
{
}
