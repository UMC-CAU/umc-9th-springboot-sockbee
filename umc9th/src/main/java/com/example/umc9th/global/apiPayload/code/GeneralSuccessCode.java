package com.example.umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public enum GeneralSuccessCode implements BaseSuccessCode {

    COMMON000(HttpStatus.OK, "요청이 성공적으로 처리되었습니다."),
    COMMON2001(HttpStatus.CREATED, "리소스가 성공적으로 생성되었습니다."),
    COMMON2002(HttpStatus.NO_CONTENT, "요청은 성공했지만 반환할 데이터가 없습니다."),
    COMMON2003(HttpStatus.OK, "리소스가 성공적으로 수정되었습니다."),
    COMMON2004(HttpStatus.NO_CONTENT, "리소스가 성공적으로 삭제되었습니다.");

    private final HttpStatus status;
    private final String message;

    GeneralSuccessCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
