package com.example.umc9th.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ReviewRequestDTO {

    @NotBlank
    private String content;

    //0.0 ~ 5.0 사이 별점 제약
    @NotNull
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "5.0")
    @Digits(integer = 1, fraction = 2)
    private BigDecimal star;

    // 인증 정보를 요청에 포함
    private Long memberId;
}
