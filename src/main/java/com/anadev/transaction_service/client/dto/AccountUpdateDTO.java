package com.anadev.transaction_service.client.dto;

import com.anadev.transaction_service.database.collection.enums.TypeTransaction;

import java.math.BigDecimal;

public record AccountUpdateDTO (

        BigDecimal value,
        TypeTransaction type)
{

}