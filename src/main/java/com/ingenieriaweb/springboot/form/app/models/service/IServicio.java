package com.ingenieriaweb.springboot.form.app.models.service;

//Es mejor una interfaz para que las clases concretas como Miservicio la implementen 
//y sea menos acoplado cuando cambien.

public interface IServicio {
	public String operacion();

}
