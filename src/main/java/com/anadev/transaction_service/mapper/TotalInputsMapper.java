package com.anadev.transaction_service.mapper;

import com.anadev.transaction_service.database.DTO.TotalInputsResponse;
import com.anadev.transaction_service.service.TransactionService;

import java.math.BigDecimal;

public final class TotalInputsMapper {

    private TransactionService transactionService;


    public static TotalInputsResponse toInputsResponse(BigDecimal totalInputs){

        return TotalInputsResponse.builder()
                .totalInputs(totalInputs.toPlainString()).build();
    }

}
