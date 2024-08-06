package com.tnbin.popom.domain.user.dto.constant;

import com.tnbin.popom.global.common.mybatis.CodeEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.06
 */

@RequiredArgsConstructor
@Getter
public enum RoleType implements CodeEnum {
    USER ("ROLE_USER", "일반회원"),
    ADMIN ("ROLE_ADMIN", "관리자");

    private final String code;
    private final String desc;

    @Override
    public String getCodeEnum() {
        return code;
    }
}
