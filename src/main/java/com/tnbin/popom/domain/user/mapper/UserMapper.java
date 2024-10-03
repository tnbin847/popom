package com.tnbin.popom.domain.user.mapper;

import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.dto.UserRoleRegister;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@Mapper
public interface UserMapper {
    /* 사용자 아이디 중복 검증을 위한 동일한 아이디의 총 개수 조회 */
    int selectCountByUserId(String userId);

    /* 이메일 중복 검증을 위한 동일한 이메일의 총 개수 조회 */
    int selectCountByEmail(String email);

    /* 회원가입 정보를 등록 */
    int insertUser(SignUpRequest signUpRequest);

    /* 가입된 계정에게 부여될 권한 정보를 등록 */
    void insertUserRole(UserRoleRegister userRoleRegister);
}
