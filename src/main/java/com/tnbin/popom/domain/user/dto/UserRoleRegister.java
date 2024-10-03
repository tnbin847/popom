package com.tnbin.popom.domain.user.dto;

import com.tnbin.popom.domain.user.dto.enums.Role;
import com.tnbin.popom.global.utils.StatusType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserRoleRegister {
    private Long uId;
    private Role role;
    private String usedAt;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public UserRoleRegister(Long uId, Role role, StatusType statusType) {
        this.uId = uId;
        this.role = role;
        this.usedAt = statusType.getSymbol();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }
}