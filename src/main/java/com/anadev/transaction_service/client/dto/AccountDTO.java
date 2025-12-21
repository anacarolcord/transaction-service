package com.anadev.transaction_service.client.dto;

import com.anadev.transaction_service.client.dto.enums.TypeAccount;
import com.anadev.transaction_service.client.dto.enums.TypeCurrency;

public record AccountDTO(
        Long idAccount,
        String name,
        TypeAccount typeAccount,
        TypeCurrency currency,
        Double currentBalance,
        Double monthlyLimit)
{

}