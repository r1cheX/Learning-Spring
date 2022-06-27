package com.ingenieriaweb.springboot.form.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ingenieriaweb.springboot.form.app.models.service.IServicio;
import com.ingenieriaweb.springboot.form.app.models.service.MiServicio;
import com.ingenieriaweb.springboot.form.app.models.service.MiServicioComplejo;


@Configuration
public class AppConfig {
//	Esto se utiliza cuando usamos clases externas, normalmente usaremos @Component
	
	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
//	Esto hara que esta clase sea tomada como primaria
	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo() ;
	}
	
	

}
