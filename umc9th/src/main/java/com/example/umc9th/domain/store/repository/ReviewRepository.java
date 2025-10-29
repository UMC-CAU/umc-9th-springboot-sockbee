package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.store.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
