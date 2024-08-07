package com.tnbin.popom.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 상태 값에 대하여 중복을 최대한 줄이고, 효율적으로 처리하기 위해 다른 타입이지만 유사한 의미를 가지고 있는 값들끼리
 * 묶어서 정의한 열거형 클래스
 *
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-08
 */

@RequiredArgsConstructor
@Getter
public enum State {
    YES ("Y", 1, true),
    NO ("N", 0, false);

    private final String stringFlag;        // 문자열 상태값
    private final int intFlag;              // 정수형 상태값
    private final boolean booleanFlag;      // 논리형 상태값

    /**
     * 인자로 받은 정수형의 값을 토대로 알맞은 논리형의 상태값을 반환하며, 이때 인자로 {@code 1} 또는 {@code 0}으로 전달될 경우에 예외 발생 없이 정상적으로 처리.
     *
     * @param value     정수형 값
     * @return          {@code true} 또는 {@code false}의 논리형 상태 값
     */
    public boolean toBooleanType(int value) {
        return Arrays.stream(values())
                .filter(state -> state.getIntFlag() == value)
                .findFirst()
                .map(State::isBooleanFlag)
                .orElseThrow(() -> new IllegalArgumentException("This '" + value + "' is not valid value!"));
    }
}