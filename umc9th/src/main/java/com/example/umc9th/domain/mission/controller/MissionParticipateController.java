package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionParticipateResponse;
import com.example.umc9th.domain.mission.service.MissionParticipateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionParticipateController {

    private final MissionParticipateService missionParticipateService;

    @PostMapping("/{missionId}/participate")
    public ResponseEntity<MissionParticipateResponse> participate(@PathVariable Long missionId) {
        Long memberId = 1L; // TODO: 인증에서 가져오기
        MissionParticipateResponse response = missionParticipateService.participate(memberId, missionId);
        return ResponseEntity.ok(response);
    }
}
