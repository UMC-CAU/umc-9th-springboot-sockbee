package com.example.umc9th.global.apiPayload.code.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    // 회원 관련 에러
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "MEMBER404_1",
            "존재하지 않는 회원입니다."),

    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT,
            "MEMBER409_1",
            "이미 존재하는 이메일입니다."),

    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED,
            "MEMBER401_1",
            "비밀번호가 일치하지 않습니다."),

    ACCOUNT_BANNED(HttpStatus.FORBIDDEN,
            "MEMBER403_1",
            "정지된 계정입니다."),

    ACCOUNT_INACTIVE(HttpStatus.FORBIDDEN,
            "MEMBER403_2",
            "비활성화된 계정입니다."),

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED,
            "MEMBER401_2",
            "인증이 필요합니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}

