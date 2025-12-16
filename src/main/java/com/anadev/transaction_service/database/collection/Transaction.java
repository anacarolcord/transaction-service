package com.anadev.transaction_service.database.collection;

import com.anadev.transaction_service.database.collection.enums.TypeCategory;
import com.anadev.transaction_service.database.collection.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "TRANSACAO")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Transaction {

    @Id
    private ObjectId id;
    @Field(name = "contaId")
    private Long accountId;
    @Field(name = "userId")
    private Long userId;
    @Field(name = "tipoTransacao")
    private TypeTransaction type;
    @Field(name = "valor")
    private Double amount;
    @Field(name = "categoria")
    private TypeCategory category;
    @Field(name = "criadoEm")
    private LocalDateTime occurredAt;
    @Field(name = "descricao")
    private String description;


    public Transaction() {
        this.occurredAt = LocalDateTime.now();
    }

}
