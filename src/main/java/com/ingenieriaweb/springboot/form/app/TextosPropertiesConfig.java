package com.ingenieriaweb.springboot.form.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Para cargar los datos que pusimos en textos.properties
@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {
	

}
