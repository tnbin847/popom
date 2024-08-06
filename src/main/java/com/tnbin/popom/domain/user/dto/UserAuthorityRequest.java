package com.tnbin.popom.domain.user.dto;

import com.tnbin.popom.domain.user.dto.constant.RoleType;
import com.tnbin.popom.global.utils.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.06
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserAuthorityRequest {
    private Long userId;
    private RoleType role;
    private String usedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserAuthorityRequest(Long userId, RoleType role, State state) {
        this.userId = userId;
        this.role = role;
        this.usedAt = state.getStrFlag();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
