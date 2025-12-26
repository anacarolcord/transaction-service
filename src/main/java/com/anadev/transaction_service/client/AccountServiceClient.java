package com.anadev.transaction_service.client;

import com.anadev.transaction_service.client.dto.AccountDTO;
import com.anadev.transaction_service.client.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceClient {

    private final WebClient webClient;

    public AccountServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<AccountDTO> getAccountById(Long userId, Long accountId) {
        return webClient.get()
                .uri("/users/{idUser}/accounts/{idAccount}", userId, accountId)
                .retrieve()
                .bodyToMono(AccountDTO.class);
    }

    public Mono<AccountDTO> getMonthlyLimit(Long userId, Long accountId){
        Mono<AccountDTO> account = getAccountById(userId,accountId);
        webClient.get()
                .uri()

    }

    public void setCurrencyBalance(Long idUser, Long accountId, Double value){
        webClient.patch()
                .uri("/users/{idUser}/accounts/{idAccount}/balance", idUser ,accountId)
                .bodyValue(value)
                .retrieve()
                .bodyToMono(AccountDTO.class);

    }







}
