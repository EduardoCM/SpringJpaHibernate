package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(1003L);
		
		logger.info("Courseeee 1003 -> {}", course);
		
		repository.deleteById(1003L);
		
		logger.info("Deleting 103 :: ");
		
		repository.save(new Course("Solutions digitals Arquitect"));
		
		repository.playWithEntityManager();
	
	
	}
	
	
	
}
