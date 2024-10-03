package com.tnbin.popom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "popom/index";
	}

	@GetMapping("/sign-up")
	public String signup() {
		return "popom/user/signup";
	}

	@GetMapping("/find-id")
	public String findId() {
		return "popom/user/find_id";
	}

	@GetMapping("/find-pwd")
	public String findPwd() {
		return "popom/user/find_pwd";
	}

}
