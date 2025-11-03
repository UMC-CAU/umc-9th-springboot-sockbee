package com.example.umc9th.domain.store.repository.impl;

import com.querydsl.core.types.Projections;
import com.example.umc9th.domain.store.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.member.entity.QMember;
import com.example.umc9th.domain.store.repository.custom.ReviewRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewResponseDTO> findMyReviews(Long userId, Long storeId, Integer starGroup) {
        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        var query = queryFactory
                //Projections는 new로 인스턴스를 만드는 클래스가 아니라 static helper 클래스이므로
                //new 없이 정적 메서드로 호출해야함.
                .select(com.querydsl.core.types.Projections.constructor(
                        ReviewResponseDTO.class,
                        review.reviewId,
                        store.id,
                        store.name,
                        review.star,
                        review.content,
                        review.createdAt
                ))
                .from(review)
                .join(review.store, store)
                .join(review.member, member)
                .where(member.userId.eq(userId));

        if (storeId != null) {
            query.where(store.id.eq(storeId));
        }

        if (starGroup != null) {
            double min = starGroup;
            double max = starGroup + 0.9;
            query.where(review.star.between(min, max));
        }

        return query
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}
