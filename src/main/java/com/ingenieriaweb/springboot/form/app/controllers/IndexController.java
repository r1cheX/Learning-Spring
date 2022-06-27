package com.ingenieriaweb.springboot.form.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ingenieriaweb.springboot.form.app.models.service.IServicio;
import com.ingenieriaweb.springboot.form.app.models.service.MiServicio;

@Controller
public class IndexController {

//	Sin poner el @Component en dicha clase
//	private MiServicio miservicio = new MiServicio();
	
//	Ahora que ya pusimos @Component, podemos inyectar las dependencias sin necesidad de instanciar el objeto
//	@Autowired
//	private IServicio miservicio;
	
//	Para inyectar otra clase que no es primaria llamamos Qualifier
//	@Autowired
//	@Qualifier("MiServicioComplejo")
//	private IServicio miservicio;
	
	
//	Acá llamo desde AppConfig
	@Autowired
	@Qualifier("miServicioComplejo")
	private IServicio miservicio;
	
	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("objeto",miservicio.operacion());
		return "index";
	}
	
//	Inyeccion por constructor
//	@Autowired
//	public IndexController(IServicio miservicio) {
//		this.miservicio = miservicio;
//	}
	
//	Inyeccion por set
//	@Autowired
//	public void setMiservicio(IServicio miservicio) {
//		this.miservicio = miservicio;
//	}
}
