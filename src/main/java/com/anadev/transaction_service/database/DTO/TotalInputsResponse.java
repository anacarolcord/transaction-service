package com.anadev.transaction_service.database.DTO;

import lombok.Builder;

@Builder
public record TotalInputsResponse(
        String totalInputs
){
}
