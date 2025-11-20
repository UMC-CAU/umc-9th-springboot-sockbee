package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.status.SuccessStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/review")
    public ApiResponse<ReviewResponseDTO> createReview(
            @PathVariable Long storeId,
            @Validated @RequestBody ReviewRequestDTO requestDTO
    ) {
        // 실제로는 SecurityContext에서 memberId 추출
        Long memberId = getCurrentMemberId();

        ReviewResponseDTO responseDTO = reviewService.createReview(storeId, memberId, requestDTO);
        return ApiResponse.onSuccess(SuccessStatus.REVIEW_CREATE_SUCCESS, responseDTO);
    }

    // 10주차 이후 스프링 시큐리티 연동 시 실제 구현
    private Long getCurrentMemberId() {
        return 1L;
    }
}
