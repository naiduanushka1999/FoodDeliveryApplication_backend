package com.cg.fda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class FoodDeliveryApplication extends SpringBootServletInitializer{
	private static final Logger LOGGER = LogManager.getLogger(FoodDeliveryApplication.class);
	/**
	* This method contains main method to start spring boot application
	* @param args
	*/
	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);
		LOGGER.info("Application started at port 8081");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(FoodDeliveryApplication.class);
	}
}
