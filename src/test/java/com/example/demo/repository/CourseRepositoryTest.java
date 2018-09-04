package com.example.demo.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.SpringJpaHibernateApplication;
import com.example.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaHibernateApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Test
	public void contectLoads() {
		Course course = repository.findById(1002L);
		assertEquals("Spring boot Expert", course.getName());

	}
}
