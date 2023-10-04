package com.ecm.spring.enroll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class HomeController {

	// 여신등록
//	@PostMapping("enroll/create")
	public String home() {
		System.out.println("여신등록");
		return "success";
	}
}
