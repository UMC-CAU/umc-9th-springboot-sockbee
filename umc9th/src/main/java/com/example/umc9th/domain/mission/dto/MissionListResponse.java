package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MissionListResponse {

    private final Long storeId;
    private final String storeName;
    private final int page;
    private final int size;
    private final long totalElements;
    private final int totalPages;
    private final List<MissionSummaryDTO> missions;
}

