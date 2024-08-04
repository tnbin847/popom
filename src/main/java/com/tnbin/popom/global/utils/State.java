package com.tnbin.popom.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */

@RequiredArgsConstructor
@Getter
public enum State {
    YES ("Y", 1, true),
    NO ("N", 0, false);

    private final String stringType;    // 문자열 타입의 상태 값
    private final int integerType;      // 정수형 상태 값
    private final boolean booleanType;  // 논리형 상태 값

    /**
     * 인자로 전달받은 정수형의 값을 논리형의 상태값으로 변환
     *
     * @param flag  논리형 상태값으로 변환하고자 하는 정수형 상태값
     * @return      {@code true} 또는 {@code false}
     */
    public static boolean toBooleanType(final int flag) {
        return Arrays.stream(values())
                .filter(state -> state.getIntegerType() == flag)
                .findFirst()
                .map(State::isBooleanType)
                .orElseThrow(() -> new IllegalArgumentException("This '" + flag + "' is not valid value!"));
    }//end toBooleanType()
}
