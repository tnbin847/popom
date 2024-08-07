package com.tnbin.popom.domain.user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자에게 부여될 권한 정보를 아래 두 가지로만 고정적으로 사용할 예정이기에 디비 테이블로 관리하기 보단 코드단에서 정의 및 관리하는 것이 효율적일 것이라는 판단 하에
 * 권한 코드와 설명을 정의한 열거형 클래스
 *
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-08
 */

@RequiredArgsConstructor
@Getter
public enum Role {
    USER ("ROLE_USER", "일반회원"),
    ADMIN ("ROLE_ADMIN", "관리자");

    private final String code;
    private final String title;
}
