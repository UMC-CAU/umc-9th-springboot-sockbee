package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewListResponse;
import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.success.ReviewSuccesssCode;
import com.example.umc9th.global.annotation.PageParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
@Tag(name = "리뷰 API")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/review")
    @Operation(summary = "리뷰 작성", description = "특정 가게에 대한 리뷰를 등록합니다.")
    public ApiResponse<ReviewResponseDTO> createReview(
            @PathVariable Long storeId,
            @Validated @RequestBody ReviewRequestDTO requestDTO
    ) {
        // 실제로는 SecurityContext에서 memberId 추출
        Long memberId = getCurrentMemberId();

        ReviewResponseDTO responseDTO = reviewService.createReview(storeId, memberId, requestDTO);
        return ApiResponse.onSuccess(ReviewSuccesssCode.REVIEW_CREATE_SUCCESS, responseDTO);
    }

    @GetMapping("/me/reviews")
    @Operation(summary = "내 리뷰 목록", description = "로그인한 사용자가 작성한 리뷰 목록을 페이지 단위로 조회합니다.")
    public ApiResponse<ReviewListResponse> getMyReviews(
            @PageParam @Parameter(description = "1 이상의 페이지 번호") Pageable pageable
    ) {
        Long memberId = getCurrentMemberId();
        ReviewListResponse response = reviewService.getMyReviews(memberId, pageable);
        return ApiResponse.onSuccess(ReviewSuccesssCode.REVIEW_LIST_SUCCESS, response);
    }

    // 10주차 이후 스프링 시큐리티 연동 시 실제 구현
    private Long getCurrentMemberId() {
        return 1L;
    }
}
