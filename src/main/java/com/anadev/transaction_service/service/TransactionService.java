package com.anadev.transaction_service.service;

import com.anadev.transaction_service.database.DTO.TransactionRequest;
import com.anadev.transaction_service.database.DTO.TransactionResponse;
import com.anadev.transaction_service.database.collection.Transaction;
import com.anadev.transaction_service.database.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionResponse saveTransaction(TransactionRequest data){

        Transaction transaction = new Transaction();
        transaction.setAccountId(data.accountId());
        transaction.setUserId(data.userId());
        transaction.setType(data.type());
        transaction.setAmount(data.amount());
        transaction.setCategory(data.category());
        transaction.setDescription(data.description());

        transactionRepository.save(transaction);

        return TransactionResponse.fromTransaction(transaction);
    }
}
