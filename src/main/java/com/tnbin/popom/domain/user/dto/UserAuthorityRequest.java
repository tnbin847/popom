package com.tnbin.popom.domain.user.dto;

import com.tnbin.popom.domain.user.constant.Role;
import com.tnbin.popom.global.utils.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-08
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserAuthorityRequest {
    private Long userId;
    private Role role;
    private String usedAt;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public UserAuthorityRequest(Long userId, Role role, State state) {
        this.userId = userId;
        this.role = role;
        this.usedAt = state.getStringFlag();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }
}
