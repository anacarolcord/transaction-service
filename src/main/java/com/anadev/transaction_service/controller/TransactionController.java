package com.anadev.transaction_service.controller;

import com.anadev.transaction_service.database.DTO.TransactionRequest;
import com.anadev.transaction_service.database.DTO.TransactionResponse;
import com.anadev.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponse saveTransaction(@RequestBody TransactionRequest data){
        return transactionService.saveTransaction(data);
    }
}
