package com.tnbin.popom.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * <p>상태 여부 값에 대해 서로 다른 타입의 상응되는 의미를 지닌 값들을 묶어 정의한 열거형 클래스</p>
 * 
 * @author 박 수 빈
 * @version 1.0
 */

@RequiredArgsConstructor
@Getter
public enum StatusType {
    YES (1, "Y", true),
    NO (0, "N", false);

    private final int number;       // 정수형 상태값
    private final String symbol;    // 문자열 상태값
    private final boolean flag;     // 논리형 상태값

    /**
     * 전달 받은 정수형의 값을 알맞은 논리형의 상태 여부 값으로 변환한다
     */
    public boolean toBoolean(int value) {
        return Arrays.stream(values())
                .filter(statusType -> statusType.getNumber() == value)
                .findFirst()
                .map(StatusType::isFlag)
                .orElseThrow(() -> new IllegalArgumentException(value + " is a not valid value!"));
    }
}