package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewResponseDTO {

    private final Long reviewId;
    private final String userName;
    private final String storeName;
    private final BigDecimal star;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}