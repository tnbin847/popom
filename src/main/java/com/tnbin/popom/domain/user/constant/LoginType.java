package com.tnbin.popom.domain.user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자가 어떠한 방식에 따라 가입 할 지에 따라 로그인 방식도 정해질 수 있기에, 이를 구분하기 위해 정의한 열거형 클래스
 * 
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-08
 */

@RequiredArgsConstructor
@Getter
public enum LoginType {
    GENERAL ("GENERAL", "일반"),
    SOCIAL ("OAUTH", "소셜");

    private final String code;
    private final String title;
}
