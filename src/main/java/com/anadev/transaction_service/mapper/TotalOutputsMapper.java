package com.anadev.transaction_service.mapper;

import com.anadev.transaction_service.database.DTO.TotalOutputsResponse;

import java.math.BigDecimal;

public final class TotalOutputsMapper {

    private TotalOutputsMapper(){}

     public static TotalOutputsResponse toOutputResponse(BigDecimal outputs){
         return TotalOutputsResponse.builder()
                 .totalOutputs(outputs.toPlainString())
                 .build();
     }
}
