package com.tnbin.popom.global.error;

import com.tnbin.popom.global.common.response.ApiEnum;
import com.tnbin.popom.global.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * <p>발생된 예외를 캐치하여 그에 맞는 에러 응답을 반환하는 역할의 전역 예외 처리 클래스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ApiResponse<Object>> handleRequestValidException(BindException e) {
        final List<CustomFieldError> errors = CustomFieldError.of(e.getBindingResult());
        return ApiResponse.fail(ApiEnum.INVALID_PARAMETER_VALUE, errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ApiResponse<Object>> handleConstraintViolaionException(ConstraintViolationException e) {
        final List<CustomFieldError> errors = CustomFieldError.of(e.getConstraintViolations());
        return ApiResponse.fail(ApiEnum.INVALID_PARAMETER_VALUE, errors);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponse<Object>> handleException(Exception e) {
        return ApiResponse.error(ApiEnum.INTERNAL_SERVER_ERROR);
    }
}
