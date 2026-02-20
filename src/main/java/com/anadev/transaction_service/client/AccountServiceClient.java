package com.anadev.transaction_service.client;

import com.anadev.transaction_service.client.dto.AccountUpdateDTO;
import com.anadev.transaction_service.client.dto.TransactionRequestDTO;
import com.anadev.transaction_service.database.DTO.TransactionRequest;
import com.anadev.transaction_service.exception.AccountLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Service
public class AccountServiceClient {


    private final RestClient restClient;

    public AccountServiceClient(RestClient accountRestClient) {
        this.restClient = accountRestClient;
    }

    public void updateAccount(TransactionRequest data){
        AccountUpdateDTO body = new AccountUpdateDTO(data.value(),data.type());

        this.restClient.patch()
                .uri("/accounts/{id}", data.accountId())
                .body(body)
                .retrieve()
                .onStatus(status -> status.value() == 422, (request, response) -> {
                    throw new AccountLimitExceededException("Transação negada: Limite mensal excedido.", data);
                })
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new RuntimeException("Erro tecnico: "+ response.getStatusCode() +response.getStatusText() );
                })
                .toBodilessEntity();
    }




}
