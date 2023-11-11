package com.dcs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dcs.dto.DeveloperDTO;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		System.out.println("Successfull");
		
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
