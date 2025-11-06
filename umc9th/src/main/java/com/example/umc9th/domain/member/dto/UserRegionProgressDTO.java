package com.example.umc9th.domain.member.dto;

public record UserRegionProgressDTO(
        Long regionId,
        String regionName,
        Long clearedCount,
        Long totalCount
) {}
