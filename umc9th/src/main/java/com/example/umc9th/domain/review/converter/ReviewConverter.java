package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewListResponse;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public final class ReviewConverter {

    private ReviewConverter() {
    }

    public static ReviewResponseDTO toResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .reviewId(review.getReviewId())
                .userName(review.getMember().getName())
                .storeName(review.getStore().getName())
                .star(review.getStar())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public static ReviewListResponse toListResponse(Page<ReviewResponseDTO> page) {
        List<ReviewResponseDTO> items = page.getContent();

        return ReviewListResponse.builder()
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .reviews(items)
                .build();
    }

    public static List<ReviewResponseDTO> toResponseDTOs(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toResponseDTO)
                .collect(Collectors.toList());
    }
}

