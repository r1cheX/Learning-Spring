package com.ingenieriaweb.springboot.app.controllers;

import com.ingenieriaweb.springboot.app.models.dao.IAreaDao;
import com.ingenieriaweb.springboot.app.models.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("area")
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaDao areaDao;

    @RequestMapping(value = "/")
    public String welcome(Model model) {
        model.addAttribute("titulo", "Bienvenido");
        return "welcome";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Áreas");
        model.addAttribute("areas", areaDao.findAll());
        return "area/listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {

        Area area = new Area();
        model.put("area", area);
        model.put("titulo", "Formulario de Area");
        return "area/form";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model) {

        Area area = null;

        if(id > 0) {
            area = areaDao.findOne(id);
        } else {
            return "redirect:/area/listar";
        }
        model.addAttribute("area", area);
        model.addAttribute("titulo", "Editar Area");
        return "area/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Area area, BindingResult result, Model model, SessionStatus status) {

        if(result.hasErrors()) {
            return "area/form";
        }
        areaDao.save(area);
        status.setComplete();
        return "redirect:/area/listar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        if(id > 0) {
            areaDao.delete(id);
        }
        return "redirect:/area/listar";
    }

    @RequestMapping(value="/buscarArea/{id}")
    public String buscarArea(@PathVariable(value="id") Long id, Model model) {
        Area area = null;
        if(id > 0) {
            area = areaDao.findOne(id);
        } else {
            return "redirect:/area/listar";
        }
        model.addAttribute("area", area);
        model.addAttribute("titulo", "Área específica");
        return "area/especifica";
    }

}
