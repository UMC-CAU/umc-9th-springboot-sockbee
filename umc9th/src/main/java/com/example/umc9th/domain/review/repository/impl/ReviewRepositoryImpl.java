package com.example.umc9th.domain.review.repository.impl;

import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.member.entity.QMember;
import com.example.umc9th.domain.review.custom.ReviewRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
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
                .select(Projections.constructor(
                        ReviewResponseDTO.class,
                        review.reviewId,
                        member.name,
                        store.name,
                        review.star,
                        review.content,
                        review.createdAt,
                        review.updatedAt
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

        return query.orderBy(review.createdAt.desc()).fetch();
    }

    @Override
    public Page<ReviewResponseDTO> findMyReviews(Long userId, Pageable pageable) {
        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        var contentQuery = queryFactory
                .select(Projections.constructor(
                        ReviewResponseDTO.class,
                        review.reviewId,
                        member.name,
                        store.name,
                        review.star,
                        review.content,
                        review.createdAt,
                        review.updatedAt
                ))
                .from(review)
                .join(review.member, member)
                .join(review.store, store)
                .where(member.userId.eq(userId))
                .orderBy(review.updatedAt.desc(), review.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        var countQuery = queryFactory
                .select(review.count())
                .from(review)
                .where(review.member.userId.eq(userId));

        return PageableExecutionUtils.getPage(contentQuery.fetch(), pageable, countQuery::fetchOne);
    }
}
