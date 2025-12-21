package com.anadev.transaction_service.client.dto;

import com.anadev.transaction_service.client.dto.enums.TypeUser;

import java.time.LocalDateTime;

public record UserDTO(
        Long id,
        String name,
        String email,
        TypeUser typeUser,
        LocalDateTime createdAt)
{

}