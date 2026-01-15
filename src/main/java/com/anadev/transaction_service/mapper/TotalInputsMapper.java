package com.anadev.transaction_service.mapper;

import com.anadev.transaction_service.database.DTO.TotalInputsResponse;

import java.math.BigDecimal;

public final class TotalInputsMapper {

    private TotalInputsMapper(){}

    public static TotalInputsResponse toInputsResponse(BigDecimal totalInputs){

        return TotalInputsResponse.builder()
                .totalInputs(totalInputs.toPlainString()).build();
    }



}
