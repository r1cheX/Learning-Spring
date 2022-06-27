package com.ingenieriaweb.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Para redirigir rutas
@Controller
@RequestMapping("aea")
public class HomeController {
	
//	Cuando es redirect , los parámetros se pierden
	@GetMapping("/")
	public String home() {
		return "redirect:/app/index";
	}
	
	@GetMapping("/gugol")
	public String google() {
		return "redirect:https://www.google.com";
	}
	
//	forward solo funciona para el proyecto
	@GetMapping("/p")
	public String homef() {
		return "forward:/params/";
	}

}
