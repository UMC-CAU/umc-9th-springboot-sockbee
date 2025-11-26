package com.example.umc9th.global.apiPayload.code.success;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewSuccesssCode implements BaseSuccessCode {

    REVIEW_CREATE_SUCCESS(HttpStatus.CREATED, "REVIEW_201", "리뷰가 성공적으로 등록되었습니다."),
    REVIEW_LIST_SUCCESS(HttpStatus.OK, "REVIEW_200_1", "리뷰 목록을 성공적으로 조회했습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ReviewSuccesssCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return this.httpStatus;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
