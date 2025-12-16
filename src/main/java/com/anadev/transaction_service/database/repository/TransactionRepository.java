package com.anadev.transaction_service.database.repository;

import com.anadev.transaction_service.database.collection.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, ObjectId> {

}
