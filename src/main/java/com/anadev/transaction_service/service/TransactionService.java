package com.anadev.transaction_service.service;

import com.anadev.transaction_service.client.AccountServiceClient;
import com.anadev.transaction_service.client.dto.UserDTO;
import com.anadev.transaction_service.database.DTO.TransactionRequest;
import com.anadev.transaction_service.database.DTO.TransactionResponse;
import com.anadev.transaction_service.database.collection.Transaction;
import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import com.anadev.transaction_service.database.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountServiceClient accountService;

    public TransactionResponse createTransaction(TransactionRequest data){

        Transaction transaction = new Transaction();
        transaction.setAccountId(data.accountId());
        transaction.setUserId(data.userId());
        transaction.setType(data.type());
        transaction.setAmount(data.amount());
        transaction.setCategory(data.category());
        transaction.setDescription(data.description());
        transaction.setOccurredAt(LocalDateTime.now());

        transactionRepository.save(transaction);

        TransactionResponse updated = TransactionResponse.fromTransaction(transaction);
        accountService.updateAccount(updated);

        return updated;
    }

    public BigDecimal getTotalOutputs(Long userId, LocalDateTime startDate, LocalDateTime endDate){

       List<TransactionResponse> filtered = this.getAllByUserAndDate(userId,startDate,endDate);

       return filtered.stream()
                .filter(f-> f.type().equals(TypeTransaction.SAIDA))
                .map(TransactionResponse::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalInputs(Long userId, LocalDateTime startDate, LocalDateTime endDate){

        List<TransactionResponse> filtered = this.getAllByUserAndDate(userId,startDate,endDate);

        return filtered.stream()
                .filter(f-> f.type().equals(TypeTransaction.ENTRADA))
                .map(TransactionResponse::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }



    public List<TransactionResponse> getAllTransactions(){

        return transactionRepository.findAll()
                .stream()
                .map(TransactionResponse::fromTransaction)
                .collect(Collectors.toList());
    }

    public TransactionResponse getTransactionById(ObjectId idTransaction){
        Transaction transaction = transactionRepository.findById(idTransaction)
                .orElseThrow(RuntimeException::new);

        return TransactionResponse.fromTransaction(transaction);
    }

    public List<TransactionResponse> getAllTransactionsByUser(Long userId){
        return transactionRepository.findAllByUserId(userId)
                .stream()
                .map(TransactionResponse::fromTransaction)
                .toList();
    }

    public List<TransactionResponse> getTransactionsByUserAndCategory(Long userId, TypeCategory category){
        return transactionRepository.findAllByUserIdAndCategory(userId, category)
                .stream()
                .map(TransactionResponse::fromTransaction)
                .collect(Collectors.toList());
    }

    public List<TransactionResponse> getTransactionsByUserAndType(Long userId, TypeTransaction typeTransaction){
        return transactionRepository.findAllByUserIdAndTypeTransaction(userId,typeTransaction)
                .stream()
                .map(TransactionResponse::fromTransaction)
                .collect(Collectors.toList());
    }

    public List<TransactionResponse> getTransactionsByUserAndDate(Long userId, LocalDateTime occurredAt) {
        return transactionRepository.findAllByOccurredAtAndUserId(occurredAt, userId)
                .stream()
                .map(TransactionResponse::fromTransaction)
                .collect(Collectors.toList());
    }

    public List<TransactionResponse> getAllByUserAndDate(Long userId, LocalDateTime startDate, LocalDateTime endDate){
       return transactionRepository.findAllByUserIdAndOccurredAtBetween(userId,startDate,endDate)
                .stream()
                .map(TransactionResponse::fromTransaction)
                .collect(Collectors.toList());
    }






}
