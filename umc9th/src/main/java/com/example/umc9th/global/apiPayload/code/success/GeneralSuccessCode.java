package com.example.umc9th.global.apiPayload.code.success;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    /*요청이 성공적으로 처리되었을 때 */
    OK(HttpStatus.OK,
            "COMMON000",
            "요청이 성공적으로 처리되었습니다."),

    /*리소스가 성공적으로 생성되었을 때 */
    CREATED(HttpStatus.CREATED,
            "COMMON2001",
            "리소스가 성공적으로 생성되었습니다."),

    /*요청은 성공했지만 반환할 데이터가 없을 때 */
    NO_CONTENT(HttpStatus.NO_CONTENT,
            "COMMON2002",
            "요청은 성공했지만 반환할 데이터가 없습니다."),

    /*리소스가 성공적으로 수정되었을 때 */
    UPDATED(HttpStatus.OK,
            "COMMON2003",
            "리소스가 성공적으로 수정되었습니다."),

    /*리소스가 성공적으로 삭제되었을 때 */
    DELETED(HttpStatus.NO_CONTENT,
            "COMMON2004",
            "리소스가 성공적으로 삭제되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
