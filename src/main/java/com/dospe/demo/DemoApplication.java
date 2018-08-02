package com.dospe.demo;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.dospe.demo.controller.dto.EmployeeListDTO;
import com.dospe.demo.persistence.domain.Employee;

@SpringBootApplication
@ComponentScan
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().
		setMatchingStrategy(MatchingStrategies.STRICT);
		
		modelMapper.addMappings(new PropertyMap<Employee, EmployeeListDTO>() {
			@Override
			protected void configure() {
				map().setFullName(source.getFullName());
			}
		});
		return modelMapper;
	}
	
}
