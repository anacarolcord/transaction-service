package com.anadev.transaction_service.controller;

import com.anadev.transaction_service.database.DTO.TotalInputsResponse;
import com.anadev.transaction_service.database.DTO.TotalOutputsResponse;
import com.anadev.transaction_service.database.DTO.TransactionRequest;
import com.anadev.transaction_service.database.DTO.TransactionResponse;
import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import com.anadev.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponse saveTransaction(@RequestBody TransactionRequest data){
        return transactionService.createTransaction(data);
    }

    @GetMapping
    public List<TransactionResponse> getAllTransactions(){

        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionResponse getTransactionById(ObjectId id){
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/{idUser}")
    public List<TransactionResponse> getAllTransactionsByUser(@PathVariable Long idUser){
        return transactionService.getAllTransactionsByUser(idUser);
    }

    @GetMapping("/{idUser}/category")
    public List<TransactionResponse> getAllTransactionsByUserAndCategory(@PathVariable Long idUser,
                                                                         TypeCategory category){
        return transactionService.getTransactionsByUserAndCategory(idUser,category);
    }

    @GetMapping("/{idUser}/type")
    public List<TransactionResponse> getAllByUserAndType(@PathVariable Long idUser, TypeTransaction typeTransaction){

        return transactionService.getTransactionsByUserAndType(idUser,typeTransaction);
    }

    @GetMapping("/{idUser}/date")
    public List<TransactionResponse> getAllByUserAndDate(@PathVariable Long idUser, LocalDateTime occurredAt){
        return transactionService.getTransactionsByUserAndDate(idUser,occurredAt);
    }

    @GetMapping("/{idUser}/total/inputs/")
    public TotalInputsResponse getTotalInputs(@PathVariable Long idUser,
                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return transactionService.getTotalInputs(idUser, startDate, endDate);

    }

    @GetMapping("/{idUser}/total/outputs/")
    public TotalOutputsResponse getTotalOutputs(@PathVariable Long idUser,
                                                @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return transactionService.getTotalOutputs(idUser, startDate, endDate);

    }




}
