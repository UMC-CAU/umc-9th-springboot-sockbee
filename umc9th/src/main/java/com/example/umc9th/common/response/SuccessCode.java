package com.example.umc9th.common.response;

import org.springframework.http.HttpStatus;

public enum SuccessCode {
    COMMON000(HttpStatus.OK, "COMMON000", "요청이 성공적으로 처리되었습니다."),
    COMMON2001(HttpStatus.CREATED, "COMMON2001", "리소스가 성공적으로 생성되었습니다."),
    COMMON2002(HttpStatus.NO_CONTENT, "COMMON2002", "요청은 성공했지만 반환할 데이터가 없습니다."),
    COMMON2003(HttpStatus.OK, "COMMON2003", "리소스가 성공적으로 수정되었습니다."),
    COMMON2004(HttpStatus.NO_CONTENT, "COMMON2004", "리소스가 성공적으로 삭제되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SuccessCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
