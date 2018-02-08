package com.sreenivaasamu.demoz.sf5.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Brigade {
	
	@Bean
	public Battalion myBattalion()
	{
		return new Battalion("Narayani Sena");
	}

}
