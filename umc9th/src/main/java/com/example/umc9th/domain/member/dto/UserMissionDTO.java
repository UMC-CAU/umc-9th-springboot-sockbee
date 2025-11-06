package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.mission.entity.Mission;

import java.time.LocalDateTime;

public record UserMissionDTO(
        Long missionId,
        Mission.Status status,
        Integer rewardPoint,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long storeId,
        String storeName
) {}
