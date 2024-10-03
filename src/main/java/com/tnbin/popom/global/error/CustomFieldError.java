package com.tnbin.popom.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>클라이언트로부터 전달 받은 요청 데이터의 검증 작업에서 발생된 에러 정보들을 가공하여 리스트 객체로 반환하는 클래스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CustomFieldError {
    private final String field;     // 에러가 발생된 필드명
    private final String value;     // 사용자 입력값
    private final String message;   // 에러가 발생된 원인

    /**
     * <p>단일 필드에 의해 에러가 발생했을 경우, 에러 리스트 객체를 반환한다.</p>
     *
     * @param field     에러가 발생된 필드명
     * @param value     필드에 담겨져 있는 값
     * @param message   에러가 발생된 원인
     * @return          에러 리스트 객체
     */
    public static List<CustomFieldError> of(String field, String value, String message) {
        final List<CustomFieldError> errors = new ArrayList<>();
        errors.add(new CustomFieldError(field, value, message));
        return errors;
    }

    /**
     * <p>{@code @Valid}에 의해 유효성 검증 수행으로 인해 에러 발생시, 에러에 대한 정보를 에러 리스트 객체로 반환한다.
     * {@code @RequestBody}를 이용해 받은 파라미터가 {@code @Valid}에 의해 {@link org.springframework.web.bind.MethodArgumentNotValidException} 예외 또는
     * {@code @ModelAttribute}를 이용해 받은 파라미터가 {@code @Valid}에 의해 {@link org.springframework.validation.BindException} 예외가 발생했을 경우, 검증 에러를 처리한다.</p>
     *
     * @param bindingResult 스프링에서 제공하는 발생된 에러에 대한 정보를 담고 있는 객체
     * @return 에러 리스트 객체
     */
    public static List<CustomFieldError> of(BindingResult bindingResult) {
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return fieldErrors.stream().map(fieldError -> new CustomFieldError(
                fieldError.getField(),
                fieldError.getRejectedValue() == null ? "" : fieldError.getRejectedValue().toString(),
                fieldError.getDefaultMessage()
        )).collect(Collectors.toList());
    }

    /**
     * <p>{@code @Validated}를 이용하여 입력값 검증 수행시 ConstraintViolationException 예외가 발생했을 경우의 에러를 에러 리스트 객체로 반환한다.</p>
     * @param constraintViolations  에러 정보를 담고 있는 객체
     * @return  에러 리스트 객체
     */
    public static List<CustomFieldError> of(Set<ConstraintViolation<?>> constraintViolations) {
        final List<ConstraintViolation<?>> violations = new ArrayList<>(constraintViolations);
        return violations.stream().map(violation -> new CustomFieldError(
                parsingPropertyName(violation.getPropertyPath().toString()),
                violation.getInvalidValue() == null ? "" : violation.getInvalidValue().toString(),
                violation.getMessage()
        )).collect(Collectors.toList());
    }

    /**
     * 프로퍼티 경로를 받아 그 경로에서 속성 명을 추출하여 반환한다.
     * @param propertyPath  속성(프로퍼티) 경로
     * @return  속성 명
     */
    private static String parsingPropertyName(String propertyPath) {
        return propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
    }
}