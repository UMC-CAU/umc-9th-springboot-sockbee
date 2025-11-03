package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.dto.ReviewResponseDTO;
import com.example.umc9th.domain.store.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping
    public List<ReviewResponseDTO> getMyReviews(
            @PathVariable Long userId,
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) Integer starGroup
    ) {
        return reviewQueryService.getMyReviews(userId, storeId, starGroup);
    }
}
