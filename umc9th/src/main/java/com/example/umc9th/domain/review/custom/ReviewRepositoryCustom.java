package com.example.umc9th.domain.review.custom;

import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<ReviewResponseDTO> findMyReviews(Long userId, Long storeId, Integer starGroup);
    Page<ReviewResponseDTO> findMyReviews(Long userId, Pageable pageable);
}
