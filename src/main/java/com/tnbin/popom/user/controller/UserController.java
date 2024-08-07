package com.tnbin.popom.user.controller;

import com.tnbin.popom.user.dto.SignUpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.07
 */

@RestController
public class UserController {

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
    @PostMapping
    public void addUser(@RequestBody final SignUpRequest request) {
        
    }
}
