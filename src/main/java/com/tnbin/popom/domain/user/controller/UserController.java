package com.tnbin.popom.domain.user.controller;

import com.tnbin.popom.domain.user.dto.SignUpRequest;
import com.tnbin.popom.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.07
 */

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 회원가입 페이지 호출 요청
     */
    @GetMapping("/sign-up")
    public ModelAndView signup() {
        return new ModelAndView("popom/signup");
    }

    /**
     * 회원가입 처리 요청
     */
    @PostMapping("/api/v1/user")
    public ResponseEntity<String> addUser(@RequestBody @Valid final SignUpRequest request) {
        userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
