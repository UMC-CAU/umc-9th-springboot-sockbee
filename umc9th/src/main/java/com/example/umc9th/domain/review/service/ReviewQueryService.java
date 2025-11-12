package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponseDTO> getMyReviews(Long userId, Long storeId, Integer starGroup) {
        return reviewRepository.findMyReviews(userId, storeId, starGroup);
    }
}
