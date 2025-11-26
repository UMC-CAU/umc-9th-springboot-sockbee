package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MissionSummaryDTO {

    private final Long missionId;
    private final Long storeId;
    private final String storeName;
    private final Status status;
    private final Integer rewardPoint;
    private final LocalDateTime dueDate;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}

