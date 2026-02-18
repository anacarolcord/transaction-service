package com.anadev.transaction_service.client;

import com.anadev.transaction_service.client.dto.AccountUpdateDTO;
import com.anadev.transaction_service.client.dto.TransactionRequestDTO;
import com.anadev.transaction_service.database.DTO.TransactionResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AccountServiceClient {

    private final RestClient restClient;

    public AccountServiceClient(RestClient accountRestClient) {
        this.restClient = accountRestClient;
    }

    public void updateAccount(TransactionRequestDTO data){
        AccountUpdateDTO body = new AccountUpdateDTO(data.value(),data.typeTransaction());

        this.restClient.patch()
                .uri("/accounts/{id}", data.accountId())
                .body(body)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new RuntimeException("Erro ao integrar com Account Service: "+ response.getStatusCode() + response.getStatusText());
                })
                .toBodilessEntity();
    }




}
