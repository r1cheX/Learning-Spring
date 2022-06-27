package com.ingenieriaweb.springboot.form.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros del request HTTP GET-URL");
		return "params/index";
	}

	@GetMapping("/string")
	public String param(
			@RequestParam(name = "texto", required = false, defaultValue = "Algun valor por defecto") String texto,
			Model model) {
		model.addAttribute("resultado", "El texto enviado es :" + texto);
		model.addAttribute("titulo", "Recibir parámetros del request HTTP GET-URL");
		return "params/ver";
	}

//	Enviar más parámetros
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El Saludo es : " + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

//	Ahora con HTTPServletRequest""
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
			
		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado","El saludo es : "+saludo + "y el número es: "+numero);
		return "params/ver";
	}
}
