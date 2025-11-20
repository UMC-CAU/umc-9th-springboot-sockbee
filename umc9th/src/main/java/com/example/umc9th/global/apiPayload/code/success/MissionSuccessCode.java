package com.example.umc9th.global.apiPayload.code.success;

import org.springframework.http.HttpStatus;

public enum MissionSuccessCode implements BaseSuccessCode {

    MISSION_PARTICIPATE_SUCCESS(HttpStatus.OK, "M001", "미션 참여에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    MissionSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
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
