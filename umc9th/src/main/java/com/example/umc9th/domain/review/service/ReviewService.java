package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.error.ReviewErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ReviewResponseDTO createReview(Long storeId, Long memberId, ReviewRequestDTO requestDTO) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(ReviewErrorCode.STORE_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ReviewErrorCode.MEMBER_NOT_FOUND));

        Review review = Review.builder()
                .content(requestDTO.getContent())
                .star(requestDTO.getStar())
                .store(store)
                .member(member)
                .build();

        Review saved = reviewRepository.save(review);

        return ReviewResponseDTO.builder()
                .reviewId(saved.getReviewId())
                .storeId(store.getId())
                .memberId(member.getId())
                .content(saved.getContent())
                .star(saved.getStar())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
