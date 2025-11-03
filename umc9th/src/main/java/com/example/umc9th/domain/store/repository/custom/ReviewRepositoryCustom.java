package com.example.umc9th.domain.store.repository.custom;

import com.example.umc9th.domain.store.dto.ReviewResponseDTO;
import java.util.List;

public interface ReviewRepositoryCustom {

    List<ReviewResponseDTO> findMyReviews(Long userId, Long storeId, Integer starGroup);
}
