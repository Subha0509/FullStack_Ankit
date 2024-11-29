package com.ankit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShoWHomeController {
	@RequestMapping("/home")
	public String showHome(HttpSession sc) {
		System.out.println(sc.getId());
		return "welcome"; 
	}
}
