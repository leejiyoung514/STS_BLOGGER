package com.story.blogger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "index";
	}
}
