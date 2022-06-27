package com.ingenieriaweb.springboot.form.app.controllers;
import java.util.ArrayList;
import java.util.List;

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
	
//	Esto solo funciona para una vista, pero que pasa si quieremos usarlo para varias vistas?, 
//	ver Controller2:
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Richard","Braul","xd@gmail.com"));
		usuarios.add(new Usuario("José","Braul","xd@gmail.com"));
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios",usuarios);
		return "listar";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Richard");
		usuario.setApellido("Braul Porras");
		usuario.setEmail("xd@gmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Perfil de usuario ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	

}
