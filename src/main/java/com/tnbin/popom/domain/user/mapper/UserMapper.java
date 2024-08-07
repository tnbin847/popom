package com.tnbin.popom.domain.user.mapper;

import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.dto.UserAuthorityRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author          PARK-SU-BIN
 * @since           2024-08-08
 * @version         0.1
 */

@Mapper
public interface UserMapper {
    
    /* 회원가입 정보 등록 */
    int insertUser(SignUpRequest signUpRequest);
    
    /* 가입된 회원의 권한 등록 */
    void insertUserAuthority(UserAuthorityRequest userAuthorityRequest);
}
