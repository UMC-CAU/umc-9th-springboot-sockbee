package com.example.umc9th.domain.review.controller;

import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping
    public ApiResponse<List<ReviewResponseDTO>> getMyReviews(
            @PathVariable Long userId,
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) Integer starGroup
    ) {
        List<ReviewResponseDTO> reviews = reviewQueryService.getMyReviews(userId, storeId, starGroup);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }
}
