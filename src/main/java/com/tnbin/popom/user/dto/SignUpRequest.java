package com.tnbin.popom.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.07
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SignUpRequest {
    private Long id;

    private String loginId;

    private String password;

    private String passwordConfirm;

    private String email;

    private String name;

    private String loginType;   // '일반' 또는 '소셜' : 가입하는 방식과 동일하게 방식으로 추후 로그인을 진행하기 때문

    private int activated;
}
