package com.example.umc9th.domain.mission.repository.impl;

import com.example.umc9th.domain.member.entity.QMember;
import com.example.umc9th.domain.mission.dto.MissionSummaryDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.QMission;
import com.example.umc9th.domain.mission.repository.custom.MissionRepositoryCustom;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<MissionSummaryDTO> findMissionsByStore(Long storeId, Pageable pageable) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        var contentQuery = queryFactory
                .select(Projections.constructor(
                        MissionSummaryDTO.class,
                        mission.missionId,
                        store.id,
                        store.name,
                        mission.status,
                        mission.rewardPoint,
                        mission.dueDate,
                        mission.createdAt,
                        mission.updatedAt
                ))
                .from(mission)
                .join(mission.store, store)
                .where(store.id.eq(storeId))
                .orderBy(mission.updatedAt.desc(), mission.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        var countQuery = queryFactory
                .select(mission.count())
                .from(mission)
                .where(mission.store.id.eq(storeId));

        return PageableExecutionUtils.getPage(contentQuery.fetch(), pageable, countQuery::fetchOne);
    }
}

