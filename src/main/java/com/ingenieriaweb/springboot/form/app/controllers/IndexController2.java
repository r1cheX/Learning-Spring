package com.ingenieriaweb.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ingenieriaweb.springboot.form.app.models.Usuario;

@Controller
@RequestMapping("/xd")
public class IndexController2 {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPefil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;	
	
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}

	// Para obtener el mapeo la ruta de donde se va a obtener
//	@GetMapping({ "/index", "/", "/home" })
//	public String index(Model model) {
//		model.addAttribute("titulo", "HELLO SPRING");
//		return "index";
//	}

//	Aca para pasarlo a varios formularios con @ModelAttribute
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Richard", "Braul", "xd@gmail.com"),
				new Usuario("José", "Braul", "xd@gmail.com"));
		return usuarios;
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Richard");
		usuario.setApellido("Braul Porras");
		usuario.setEmail("xd@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",textoPefil.concat(usuario.getNombre()));
		return "perfil";
	}

}
