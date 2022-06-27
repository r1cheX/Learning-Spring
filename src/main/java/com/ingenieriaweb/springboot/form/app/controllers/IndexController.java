package com.ingenieriaweb.springboot.form.app.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ingenieriaweb.springboot.form.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
		
	//Para obtener el mapeo la ruta de donde se va a obtener
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo","HELLO SPRING");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Richard");
		usuario.setApellido("Braul");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Perfil de usuario ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	

}
