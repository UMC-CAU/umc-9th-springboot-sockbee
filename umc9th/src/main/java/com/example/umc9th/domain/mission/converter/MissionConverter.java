package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionPageResponse;
import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.dto.MissionSummaryDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public final class MissionConverter {

    private MissionConverter() {
    }

    public static MissionSummaryDTO toSummary(Mission mission) {
        return MissionSummaryDTO.builder()
                .missionId(mission.getMissionId())
                .storeId(mission.getStore().getId())
                .storeName(mission.getStore().getName())
                .status(mission.getStatus())
                .rewardPoint(mission.getRewardPoint())
                .dueDate(mission.getDueDate())
                .createdAt(mission.getCreatedAt())
                .updatedAt(mission.getUpdatedAt())
                .build();
    }

    public static List<MissionSummaryDTO> toSummaries(List<Mission> missions) {
        return missions.stream()
                .map(MissionConverter::toSummary)
                .collect(Collectors.toList());
    }

    public static MissionListResponse toListResponse(Long storeId, String storeName, Page<MissionSummaryDTO> page) {
        return MissionListResponse.builder()
                .storeId(storeId)
                .storeName(storeName)
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .missions(page.getContent())
                .build();
    }

    public static MemberMissionPageResponse toMemberMissionPageResponse(Long memberId, Page<MissionSummaryDTO> page) {
        return MemberMissionPageResponse.builder()
                .memberId(memberId)
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .missions(page.getContent())
                .build();
    }
}
