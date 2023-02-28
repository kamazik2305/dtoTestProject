package com.example.dtoTestProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtoTestProjectApplication.class, args);
	}

}
