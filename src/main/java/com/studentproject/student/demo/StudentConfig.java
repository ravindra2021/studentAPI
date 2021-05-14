package com.studentproject.student.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
//			Student mariam = new Student(
//					"mariam", 
//					"mariam@gmail.com", 
//					LocalDate.of(1996, 8, 26) 
//					);
//			repository.save(mariam);
//			Student brain = new Student(
//					"brain", 
//					"brain@gmail.com", 
//					LocalDate.of(1992, 8, 26));
//			repository.saveAll(List.of(mariam,brain));
			
		};
	}
}
