package com.tnbin.popom.global.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * <p>성공 또는 에러 응답 반환시 사용될 정보들을 정의한 열거형 클래스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@RequiredArgsConstructor
@Getter
public enum ApiEnum {
    /**
     * [공통] 성공 응답 코드 정의
     */
    OK(100000, HttpStatus.OK, "요청이 성공했습니다."),
    CREATED_OK(101000, HttpStatus.CREATED, "리소스가 생성되었습니다."),
    UPDATED_OK(104010, HttpStatus.NO_CONTENT, "리소스가 변경되었습니다."),
    DELETED_OK(104020, HttpStatus.NO_CONTENT, "리소스가 삭제되었습니다."),

    /**
     * [공통] 에러 응답 코드 정의
     */
    INVALID_PARAMETER_VALUE(-800010, HttpStatus.BAD_REQUEST, "요청 파라미터의 값이 유효하지 않습니다."),
    INVALID_PARAMETER_TYPE(-800020, HttpStatus.BAD_REQUEST, "잘못된 유형의 파라미터입니다."),
    NOT_SUPPORTED_HTTP_METHOD(-805000, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP 요청 메소드입니다."),
    RESOURCE_NOT_FOUND(-804000, HttpStatus.NOT_FOUND, "요청하신 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(-900000, HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 에러가 발생했습니다.")
    ;

    private final int code;                 // 자체 정의한 정수형의 응답 코드
    private final HttpStatus statusCode;    // HTTP 상태 코드
    private final String message;           // 응답 메시지
}
