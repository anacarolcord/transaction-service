package com.anadev.transaction_service.database.DTO;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TotalOutputsResponse(
        String totalOutputs
) {
}
