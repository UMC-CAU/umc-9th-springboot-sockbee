// java
package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    private Long reviewId;       // Long
    private Long storeId;        // Long
    private String storeName;    // String
    private BigDecimal rating;   // BigDecimal
    private String content;      // String
    private LocalDateTime createdAt; // LocalDateTime
}
