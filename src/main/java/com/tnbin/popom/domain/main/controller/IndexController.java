package com.tnbin.popom.domain.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-06
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "popom/index";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "popom/signup";
    }
}
