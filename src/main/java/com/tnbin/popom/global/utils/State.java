package com.tnbin.popom.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.06
 */

@RequiredArgsConstructor
@Getter
public enum State {
    YES ("Y", 1, true),
    NO ("N", 0, false);

    private final String strFlag;
    private final int numFlag;
    private final boolean boolFlag;

    public boolean toBooleanType(int flag) {
        return Arrays.stream(values())
                .filter(state -> state.getNumFlag() == flag)
                .findFirst()
                .map(State::isBoolFlag)
                .orElseThrow(() -> new IllegalArgumentException("This '" + flag + "' is not valid value!"));
    }
}
