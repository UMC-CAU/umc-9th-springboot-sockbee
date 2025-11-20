package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<ReviewResponseDTO> findMyReviews(Long userId, Long storeId, Integer starGroup);
}
