package com.buffer.reactivedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.buffer.reactivedemo.model.Student;
import com.buffer.reactivedemo.model.StudentRepository;

@SpringBootApplication
public class ReactivedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivedemoApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			for (int i = 0; i < 20; i++) {
				Student s= new Student();
				s.setFirstname("Test" + i);
				s.setLastname("test" + i);
				s.setAge(i);
				repository.save(
				s).subscribe();
			}
		};
	}*/
}
