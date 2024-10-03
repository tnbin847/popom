package com.tnbin.popom.domain.user.dto.enums;

import com.tnbin.popom.global.common.mybatis.CodeEnum;
import lombok.RequiredArgsConstructor;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RequiredArgsConstructor
public enum Role implements CodeEnum {
    USER ("ROLE_USER", "일반회원"),
    ADMIN ("ROLE_ADMIN", "관리자");

    private final String code;
    private final String label;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
