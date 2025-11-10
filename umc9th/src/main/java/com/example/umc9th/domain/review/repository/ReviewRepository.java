package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.umc9th.domain.review.custom.ReviewRepositoryCustom;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    // 특정 매장의 리뷰 전체 조회
    List<Review> findByStoreId(Long storeId);
}
