package com.example.umc9th.domain.test.exception;

import com.example.umc9th.domain.test.exception.code.TestErrorCode;
import lombok.Getter;

@Getter
public class TestException extends RuntimeException {
    private final TestErrorCode errorCode;

    public TestException(TestErrorCode errorCode) {
        super(errorCode != null ? errorCode.toString() : null);
        this.errorCode = errorCode;
    }

}
