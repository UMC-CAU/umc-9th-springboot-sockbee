package com.example.umc9th.domain.review.dto;

import java.time.LocalDateTime;

public record ReviewResponseDTO(
        Long reviewId,
        Long storeId,
        String storeName,
        Double star,
        String content,
        LocalDateTime createdAt
) {}
