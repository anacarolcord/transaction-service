package com.anadev.transaction_service.client.dto;

import com.anadev.transaction_service.client.dto.enums.TypeAccount;
import com.anadev.transaction_service.client.dto.enums.TypeCurrency;

import java.math.BigDecimal;

public record AccountCreateDTO(
        String name,
        TypeAccount typeAccount,
        TypeCurrency currency,
        BigDecimal currentBalance,
        BigDecimal monthlyLimit
) {
}
