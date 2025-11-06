package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.dto.UserRegionProgressDTO;
import com.example.umc9th.domain.member.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRegionProgressRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        SELECT new com.example.umc9th.domain.member.dto.UserRegionProgressDTO(
            r.regionId,
            r.name,
            SUM(CASE WHEN um.status = 'COMPLETED' THEN 1 ELSE 0 END),
            COUNT(um.id)
        )
        FROM UserMission um
        JOIN um.mission m
        JOIN m.store s
        JOIN s.region r
        WHERE um.member.userId = :userId
          AND r.regionId = :regionId
        GROUP BY r.regionId, r.name
        """)
    List<UserRegionProgressDTO> findRegionProgress(
            @Param("userId") Long userId,
            @Param("regionId") Long regionId
    );
}
