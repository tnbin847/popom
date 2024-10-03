package com.tnbin.popom.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RestController
public class LoginController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("popom/index");
    }
}
