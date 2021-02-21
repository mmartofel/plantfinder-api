package com.example.plantfinder.plantfinderapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlantfinderApiApplication {
	

	static final Logger logger = LoggerFactory.getLogger(PlantfinderApiApplication.class);

	public static void main(String[] args) {
	
		SpringApplication.run(PlantfinderApiApplication.class, args);

		logger.warn("Applicartion started.");

	}

}
