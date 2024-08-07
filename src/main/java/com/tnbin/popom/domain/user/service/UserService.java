package com.tnbin.popom.domain.user.service;

import com.tnbin.popom.domain.user.constant.LoginType;
import com.tnbin.popom.domain.user.constant.Role;
import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.dto.UserAuthorityRequest;
import com.tnbin.popom.domain.user.mapper.UserMapper;
import com.tnbin.popom.global.utils.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-08
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUser(final SignUpRequest signUpDto) {
        /* 현재까지 '소셜 연동'이 구현된 것이 아니기 때문에 일단은 'GENERAL' 값을 지정 */
        signUpDto.setLoginType(LoginType.GENERAL);
        if (userMapper.insertUser(signUpDto) == 1) {
            /* 정상적으로 가입처리가 된 사용자 계정의 번호를 가져온 후 그 정보를 토대로 권한 정보를 등록 */
            userMapper.insertUserAuthority(new UserAuthorityRequest(signUpDto.getId(), Role.USER, State.YES));
        }
    }
}
