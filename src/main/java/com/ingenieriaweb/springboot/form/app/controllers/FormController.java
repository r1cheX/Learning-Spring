package com.ingenieriaweb.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ingenieriaweb.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo","Formulario de usuarios");
		return "form";
	}
	
//	No existia las clase Usuario
//	@PostMapping("/form")
//	public String procesar(Model model,
//			@RequestParam String username,
//			@RequestParam String password,
//			@RequestParam String email){
//		
//		model.addAttribute("titulo","Resultado form");
//		model.addAttribute("username",username);
//		model.addAttribute("password",password);
//		model.addAttribute("email",email);
//		return "resultado";
//	}
	
//	Si existe la clase Usuario
//	@PostMapping("/form")
//	public String procesar(Model model,
//			@RequestParam String username,
//			@RequestParam String password,
//			@RequestParam String email){
//		
//		Usuario usuario = new Usuario();
//		usuario.setUsername(username);
//		usuario.setPassword(password);
//		usuario.setEmail(email);
//		model.addAttribute("titulo","Resultado form");
//		model.addAttribute("usuario",usuario);
//		return "resultado";
//	}
	
//	Mapeando los campos del formulario al objeto Model
	@PostMapping("/form")
	public String procesar(Usuario usuario, Model model) {
		model.addAttribute("titulo","Resultado form");
		model.addAttribute("usuario",usuario);
		return "resultado";
	}
}
