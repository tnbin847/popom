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
public enum LoginType implements CodeEnum {
    GENERAL ("GENERAL", "일반계정"),
    SOCIAL ("OAUTH", "소셜계정");
    
    private final String code;
    private final String desc;

    @Override
    public String getCodeEnum() {
        return code;
    }
}
