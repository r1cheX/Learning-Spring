package com.ingenieriaweb.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.ingenieriaweb.springboot.app.models.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.ingenieriaweb.springboot.app.models.entity.*;

@Controller
@SessionAttributes("empleado")
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Autowired
	private IAreaDao areaDao;

	@RequestMapping(value = "/")
	public String welcome(Model model) {
		model.addAttribute("titulo", "Bienvenido");
		return "welcome";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Empleados");
		model.addAttribute("empleados", empleadoDao.findAll());
		return "empleado/listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Empleado empleado = new Empleado();
		model.put("empleado", empleado);
		model.put("areas", areaDao.findAll());
		model.put("titulo", "Formulario de Empleados");
		return "empleado/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {

		Empleado empleado = null;

		if (id > 0) {
			empleado = empleadoDao.findOne(id);
		} else {
			return "redirect:/empleado/listar";
		}
		model.addAttribute("empleado", empleado);
		model.addAttribute("areas", areaDao.findAll());
		model.addAttribute("titulo", "Editar Empleado");
		return "empleado/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Empleado empleado, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Empleado");
			model.addAttribute("areas", areaDao.findAll());
			return "empleado/form";
		}

		empleadoDao.save(empleado);
		status.setComplete();
		return "redirect:/empleado/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			empleadoDao.delete(id);
		}
		return "redirect:/empleado/listar";
	}

}
