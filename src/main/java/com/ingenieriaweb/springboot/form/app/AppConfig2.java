package com.ingenieriaweb.springboot.form.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ingenieriaweb.springboot.form.app.models.domain.ItemFactura;
import com.ingenieriaweb.springboot.form.app.models.domain.Producto;
import com.ingenieriaweb.springboot.form.app.models.service.IServicio;
import com.ingenieriaweb.springboot.form.app.models.service.MiServicio;
import com.ingenieriaweb.springboot.form.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig2 {

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto p1 = new Producto("Camara Sony", 100.0);
		Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200.0);
		ItemFactura linea1 = new ItemFactura(p1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		return Arrays.asList(linea1, linea2);
	}

}
