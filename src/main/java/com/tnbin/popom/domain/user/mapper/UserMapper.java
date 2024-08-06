package com.tnbin.popom.domain.user.mapper;

import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.dto.UserAuthorityRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.06
 */

@Mapper
public interface UserMapper {
    int selectCountById(String loginId);

    int selectCountByEmail(String email);

    int insertUser(SignUpRequest signUpReq);

    void insertUserAuthority(UserAuthorityRequest userAuthReq);
}
