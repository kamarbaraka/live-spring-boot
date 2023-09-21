package com.develhope.livespringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiveSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(LiveSpringBootApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){

        /*return an instance of the model mapper*/
        return new ModelMapper();
    }

}
