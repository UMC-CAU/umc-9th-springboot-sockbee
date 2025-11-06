package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.dto.UserMissionDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserMissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT new com.example.umc9th.domain.member.dto.UserMissionDTO(
            m.missionId, m.status, m.rewardPoint, m.createdAt, m.updatedAt,
            s.id, s.name
        )
        FROM Mission m
        JOIN m.store s
        WHERE m.member.userId = :userId
          AND m.status IN ('IN_PROGRESS', 'SUCCESS')
          AND (
               m.updatedAt < :updatedAt
               OR (m.updatedAt = :updatedAt AND m.missionId < :missionId)
          )
        ORDER BY m.updatedAt DESC, m.missionId DESC
        """)
    List<UserMissionDTO> findUserMissionCursorBased(
            @Param("userId") Long userId,
            @Param("updatedAt") LocalDateTime updatedAt,
            @Param("missionId") Long missionId
    );
}
