package com.example.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResponseDTO {

    private Long reviewId;
    private Long storeId;
    private Long memberId;
    private String content;
    private BigDecimal star;
    private LocalDateTime createdAt;
}