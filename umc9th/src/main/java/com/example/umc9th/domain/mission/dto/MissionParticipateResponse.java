package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.member.mapping.UserMission;
import com.example.umc9th.global.apiPayload.code.success.BaseSuccessCode;
import com.example.umc9th.global.apiPayload.code.success.MissionSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class MissionParticipateResponse implements BaseSuccessCode {

    private Long userMissionId;
    private Long missionId;
    private Long memberId;
    private UserMission.Status status;
    private LocalDate joinedAt;

    // 성공 코드 정보
    private String code;
    private String message;

    public static MissionParticipateResponse from(UserMission userMission) {
        MissionSuccessCode successCode = MissionSuccessCode.MISSION_PARTICIPATE_SUCCESS;

        return MissionParticipateResponse.builder()
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getMissionId())
                .memberId(userMission.getMember().getUserId())
                .status(userMission.getStatus())
                .joinedAt(userMission.getJoinedAt())
                .code(successCode.getCode())
                .message(successCode.getMessage())
                .build();
    }

    @Override
    public org.springframework.http.HttpStatus getStatus() {
        return MissionSuccessCode.MISSION_PARTICIPATE_SUCCESS.getStatus();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
