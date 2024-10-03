package com.tnbin.popom.domain.user.service;

import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.dto.UserRoleRegister;
import com.tnbin.popom.domain.user.dto.enums.LoginType;
import com.tnbin.popom.domain.user.dto.enums.Role;
import com.tnbin.popom.domain.user.mapper.UserMapper;
import com.tnbin.popom.global.utils.StatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public int countByUserId(final String userId) {
        return userMapper.selectCountByUserId(userId);
    }

    @Transactional(readOnly = true)
    public int countByEmail(final String email) {
        return userMapper.selectCountByEmail(email);
    }

    @Transactional
    public void addUser(final SignUpRequest signUpRequest) {
        signUpRequest.setLoginType(LoginType.DEFAULT);
        if (userMapper.insertUser(signUpRequest) == 1) {
            userMapper.insertUserRole(new UserRoleRegister(signUpRequest.getId(), Role.USER, StatusType.YES));
        }// end if
    }
}
