package com.ingenieriaweb.springboot.form.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//Anotacion @Primary la hace principal
@Component("MiServicioSimple")
public class MiServicio implements IServicio {
	
	public  String operacion() {
		return "ejecutando algun proceso SIMPLE GG IZI ...";
	}
	
	
	
}
