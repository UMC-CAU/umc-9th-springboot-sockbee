package com.example.umc9th.domain.review.custom;

import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import java.util.List;

public interface ReviewRepositoryCustom {

    List<ReviewResponseDTO> findMyReviews(Long userId, Long storeId, Integer starGroup);
}
