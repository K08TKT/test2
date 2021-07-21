package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/top")
	public String getLogin(Model model) {
		return "pc/top";
	}
	@PostMapping("/top")
	public String postLogin(Model moel) {
		return "redirect:/pc/list";
	}


}
