package com.anadev.transaction_service.client;

import com.anadev.transaction_service.client.dto.AccountDTO;
import com.anadev.transaction_service.client.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AccountServiceClient {

    private final WebClient webClient;

    public AccountServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public AccountDTO getAccountById(Long accountId) {
        return webClient.get()
                .uri("/users/{idUser}/accounts/{idAccount}", accountId)
                .retrieve()
                .bodyToMono(AccountDTO.class)
                .block();
    }

    public UserDTO getUserById(Long userId){
        return webClient.get()
                .uri("/users/{idUser}", userId)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .block();

    }

    public Double getMonthlyLimit(Long accountId){
       AccountDTO account = getAccountById(accountId);

       return account.monthlyLimit();
    }

    public Double getCurrencyBalance(Long accountId){
        AccountDTO account = getAccountById(accountId);
        return account.currentBalance();
    }

    public void setCurrencyBalance(Long accountId, Double value){
        webClient.patch()
                .uri("/{idAccount}/limit", accountId)
                .bodyValue(value)
                .retrieve()
                .bodyToMono(AccountDTO.class)
                .block();

    }





}
