package com.tnbin.popom.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tnbin.popom.global.error.CustomFieldError;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

/**
 * <p>요청 처리의 결과에 따라 성공, 실패, 에러에 대한 응답의 바디부를 구성하여 반환하는 클래스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@Getter
public class ApiResponse<T> {
    private static final String STATUS_SUCCESS = "success";
    private static final String STATUS_FAIL = "fail";
    private static final String STATUS_ERROR = "error";

    /**
     * 필수 데이터
     */
    private final String status;
    private final int code;
    private final String message;

    /**
     * 아래 두 데이터({@code data}와 {@code errors})는 응답 상태에 따라 응답 바디부에 추가될 데이터로서, {@code data}는 성공 응답의 바디부에 포함될 응답 결과 데이터로
     * 반환될 데이터가 없을 경우 {@code null} 대신 {@code 빈 객체({})}를 반환하며,{@code errors}는 실패 응답의 바디부에 포함될 에러 리스트로
     * 반환될 에러 정보가 없다면 {@code null} 대신 {@code 빈 배열([])} 반환한다.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CustomFieldError> errors;

    @Builder
    private ApiResponse(String status, int code, String message, T data, List<CustomFieldError> errors) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    /**
     * <p>성공 응답을 반환한다.</p>
     * <blockquote><pre>
     *     {
     *         "status" : "success",
     *         "code" : 1XXXXX,
     *         "message" : 성공 메시지,
     *         "data" : {}
     *     }
     * </pre></blockquote>
     *
     * @param apiEnum   응답 상태 정보를 정의한 열거형 클래스
     * @return          응답 객체
     */
    public static ResponseEntity<ApiResponse<Object>> ok(final ApiEnum apiEnum) {
        return ResponseEntity
                .status(apiEnum.getStatusCode())
                .body(ApiResponse.builder()
                        .status(STATUS_SUCCESS)
                        .code(apiEnum.getCode())
                        .message(apiEnum.getMessage())
                        .data(Collections.emptyMap())
                        .build());
    }

    /**
     * <p>성공 응답을 반환한다. (반환할 결과 데이터가 있을 경우)</p>
     * <blockquote><pre>
     *     {
     *         "status" : "success",
     *         "code" : 1XXXXX,
     *         "message" : 성공 메시지,
     *         "data" : {data} || [{data}, {data}, ...]
     *     }
     * </pre></blockquote>
     *
     * @param apiEnum   응답 상태 정보를 정의한 열거형 클래스
     * @param data      응답 결과 데이터
     * @return          응다 객체
     * @param <T>       응답 결과 데이터의 타입
     */
    public static<T> ResponseEntity<ApiResponse<T>> ok(final ApiEnum apiEnum, final T data) {
        return ResponseEntity
                .status(apiEnum.getStatusCode())
                .body(ApiResponse.<T>builder()
                        .status(STATUS_SUCCESS)
                        .code(apiEnum.getCode())
                        .message(apiEnum.getMessage())
                        .data(data)
                        .build());
    }

    /**
     * <p>필드 에러로 인한 실패 응답을 반환한다.</p>
     * <blockquote><pre>
     *     {
     *         "status" : "fail",
     *         "code" : -8XXXXX,
     *         "message" : 에러 메시지,
     *         "errors" : [] 또는 [{error data}, {error data}, ...]
     *     }
     * </pre></blockquote>
     *
     * @param apiEnum   응답 상태 정보를 정의한 열거형 클래스
     * @param errors    에러 정보 리스트
     * @return          응답 객체
     */
    public static ResponseEntity<ApiResponse<Object>> fail(final ApiEnum apiEnum, final List<CustomFieldError> errors) {
        return ResponseEntity
                .status(apiEnum.getStatusCode())
                .body(ApiResponse.builder()
                        .status(STATUS_FAIL)
                        .code(apiEnum.getCode())
                        .message(apiEnum.getMessage())
                        .errors(errors == null ? Collections.emptyList() : errors)
                        .build());
    }

    /**
     * <p>예외 발생으로 인한 에러 응답을 반환한다.</p>
     * <blockquote><pre>
     *     {
     *         "status" : "error",
     *         "code" : -9XXXXX,
     *         "message" : 에러 메시지
     *     }
     * </pre></blockquote>
     *
     * @param apiEnum   응답 상태 정보를 정의한 열거형 클래스
     * @return          응답 객체
     */
    public static ResponseEntity<ApiResponse<Object>> error(final ApiEnum apiEnum) {
        return ResponseEntity
                .status(apiEnum.getStatusCode())
                .body(ApiResponse.builder()
                        .status(STATUS_ERROR)
                        .code(apiEnum.getCode())
                        .message(apiEnum.getMessage())
                        .build());
    }
}
