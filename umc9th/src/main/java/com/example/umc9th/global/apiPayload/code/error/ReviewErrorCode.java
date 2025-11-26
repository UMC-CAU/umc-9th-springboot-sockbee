package com.example.umc9th.global.apiPayload.code.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewErrorCode implements BaseErrorCode {

    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_404", "Store 를 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_404", "Member 를 찾을 수 없습니다."),
    INVALID_PAGE(HttpStatus.BAD_REQUEST, "REVIEW_400_1", "page 파라미터는 1 이상의 정수여야 합니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ReviewErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }
}