package com.tnbin.popom.domain.user.dto;

import com.tnbin.popom.domain.user.dto.constant.LoginType;
import com.tnbin.popom.global.utils.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.06
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SignUpRequest {
    private Long id;
    private String loginId;
    @Setter
    private String password;
    private String passwordConfirm;
    private String name;
    private String email;
    private LoginType loginType;
    private final int activated = State.YES.getNumFlag();
}
