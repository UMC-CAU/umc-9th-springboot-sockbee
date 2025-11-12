package com.example.umc9th.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> {
    private final boolean success = true;
    private final String code;
    private final String message;
    private final T data;
    private final int status;

    private SuccessResponse(SuccessCode successCode, T data) {
        this.code = successCode.getCode();
        this.message = successCode.getMessage();
        this.data = data;
        this.status = successCode.getHttpStatus().value();
    }

    public static <T> SuccessResponse<T> of(SuccessCode successCode) {
        return new SuccessResponse<>(successCode, null);
    }

    public static <T> SuccessResponse<T> of(SuccessCode successCode, T data) {
        return new SuccessResponse<>(successCode, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }
}
