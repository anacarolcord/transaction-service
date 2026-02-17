package com.anadev.transaction_service.database.repository;

import com.anadev.transaction_service.database.collection.Transaction;
import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, ObjectId> {

    List<Transaction> findAllByUserId(Long userId);
    List <Transaction> findAllByUserIdAndCategory(Long userId, TypeCategory category);
    List<Transaction> findAllByUserIdAndType(Long userId, TypeTransaction type);
    List<Transaction> findAllByOccurredAtAndUserId(LocalDateTime occurredAt, Long userId);
    List<Transaction> findAllByUserIdAndOccurredAtBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);


}

