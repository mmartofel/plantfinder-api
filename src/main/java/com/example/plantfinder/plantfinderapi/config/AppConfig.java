package com.example.plantfinder.plantfinderapi.config;


import com.example.plantfinder.plantfinderapi.model.Plant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    Logger logger=LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    String port;

    @Value("${server.address}")
    String address;
    
    @Value("${spring.boot.admin.client.instance.service-base-url}")
    String service_base_url;
    
    @Value("${spring.boot.admin.client.url}")
    String url;
    

    @Bean
    public List<Plant> plants(){

        List plants=new ArrayList<Plant>();

        //Add plants
        Plant plant1=new Plant();
        plant1.setId(1);
        plant1.setName("Pothos");
        plant1.setType("Indoor");
        plants.add(plant1);

        Plant plant2=new Plant();
        plant2.setId(2);
        plant2.setName("Lily");
        plant2.setType("Outdoor");
        plants.add(plant2);

        logger.warn("Plants list initialized.");
        logger.warn("Server port is set to: " + port);
        logger.warn("Server address is set to: " + address);
        logger.warn("spring.boot.admin.client.instance.service-base-url is set to: " + service_base_url);
        logger.warn("spring.boot.admin.client.url is set to: " + url);

        return plants;

    }



}
