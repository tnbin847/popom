package com.tnbin.popom.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SUBIN PARK
 * @version 1.0
 * @since 2024.08.07
 */

@RestController
public class LoginController {

    /**
     * 로그인 페이지 호출 요청
     */
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("popom/index");
    }
}
