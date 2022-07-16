package com.ingenieriaweb.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(value = "/")
	public String welcome(Model model) {
		model.addAttribute("titulo", "Bienvenido");
		return "welcome";
	}
}
