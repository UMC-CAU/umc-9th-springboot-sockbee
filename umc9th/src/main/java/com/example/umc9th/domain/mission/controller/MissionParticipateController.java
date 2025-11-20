package com.example.umc9th.domain.mission.controller;

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
    public ResponseEntity<Long> participate(@PathVariable Long missionId) {
        // TODO: 워크북 10주차 학습 후 로그인 기능 구현 시, memberId를 인증 정보에서 가져오도록 수정
        Long memberId = 1L;

        Long userMissionId = missionParticipateService.participate(memberId, missionId);
        return ResponseEntity.ok(userMissionId);
    }
}
