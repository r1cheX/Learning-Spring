package com.ingenieriaweb.springboot.form.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//Anotacion @Primary la hace principal por defecto
@Component("MiServicioSimpleComplejo")
@Primary
public class MiServicioComplejo implements IServicio {
	
	@Override
	public  String operacion() {
		return "ejecutando algun proceso COMPLEJO ...";
	}
	
	
	
}
