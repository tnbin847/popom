package com.tnbin.popom.domain.user.controller;

import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.service.UserService;
import com.tnbin.popom.global.common.response.ApiEnum;
import com.tnbin.popom.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     *  회원가입 페이지 호출
     */
    @GetMapping("/sign-up")
    public ModelAndView signup() {
        return new ModelAndView("popom/user/signup");
    }

    /**
     *  아이디 찾기 페이지 호출
     */
    @GetMapping("/find-id")
    public ModelAndView findId() {
        return new ModelAndView("popom/user/find-id");
    }

    /**
     *  비밀번호 찾기 페이지 호출
     */
    @GetMapping("/find-pwd")
    public ModelAndView findPwd() {
        return new ModelAndView("popom/user/find-pwd");
    }

    /**
     * 동일한 아이디의 개수 조회 요청 처리
     */
    @PostMapping("/api/v1/user/duplicate/user-id")
    public ResponseEntity<ApiResponse<Integer>> findCountByUserId(@RequestParam("userId") final String userId) {
        int count = userService.countByUserId(userId);
        return ApiResponse.ok(ApiEnum.OK, count);
    }

    /**
     * 동일한 이메일의 개수 조회 요청 처리
     */
    @PostMapping("/api/v1/user/duplicate/email")
    public ResponseEntity<ApiResponse<Integer>> findCountByEmail(@RequestParam("email") final String email) {
        int count = userService.countByEmail(email);
        return ApiResponse.ok(ApiEnum.OK, count);
    }

    /**
     * 가입 정보 등록 요청 처리
     */
    @PostMapping("/api/v1/user")
    public ResponseEntity<ApiResponse<Object>> createUser(@RequestBody @Valid final SignUpRequest signUpRequest) {
        userService.addUser(signUpRequest);
        return ApiResponse.ok(ApiEnum.CREATED_OK);
    }
}