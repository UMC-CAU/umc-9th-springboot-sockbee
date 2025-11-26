package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionListResponse;
import com.example.umc9th.domain.mission.service.MissionQueryService;
import com.example.umc9th.global.annotation.PageParam;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.success.MissionSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
@Tag(name = "미션 조회 API")
public class MissionQueryController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "가게 미션 목록", description = "특정 가게에 등록된 미션 목록을 10개 단위로 페이징 조회합니다.")
    public ApiResponse<MissionListResponse> getStoreMissions(
            @PathVariable Long storeId,
            @PageParam @Parameter(description = "1 이상의 페이지 번호") Pageable pageable
    ) {
        MissionListResponse response = missionQueryService.getStoreMissions(storeId, pageable);
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_LIST_SUCCESS, response);
    }
}

