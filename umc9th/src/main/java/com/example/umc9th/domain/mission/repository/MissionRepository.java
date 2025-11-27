package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionAvailableDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.custom.MissionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    @Query("""
        SELECT new com.example.umc9th.domain.mission.dto.MissionAvailableDTO(
            m.missionId,
            m.status,
            m.rewardPoint,
            m.dueDate,
            s.id,
            s.name,
            ft.name
        )
        FROM Mission m
        JOIN m.store s
        JOIN s.tag ft
        WHERE s.region.regionId = :regionId
          AND m.status = 'AVAILABLE'
          AND (
               m.updatedAt < :updatedAt
               OR (m.updatedAt = :updatedAt AND m.missionId < :missionId)
          )
        ORDER BY m.updatedAt DESC, m.missionId DESC
        """)
    List<MissionAvailableDTO> findAvailableMissionsByRegionWithCursor(
            @Param("regionId") Long regionId,
            @Param("updatedAt") LocalDateTime updatedAt,
            @Param("missionId") Long missionId
    );
}
