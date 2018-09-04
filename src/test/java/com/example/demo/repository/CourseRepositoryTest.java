package com.example.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
	
	@Test
	public void deleteById_basic() {
		repository.deleteById(1001L);
		assertNull(repository.findById(1001L));
	}
	
	@Test
	public void save_basic() {
		Course course = repository.findById(1002L);
		course.setName("JPA Update");
		
		repository.save(course);
		assertEquals("JPA Update", repository.findById(1002L).getName());
		
		repository.save(new Course("Togaf Certified"));
		
         Course course2 = repository.findById(2L);
         
         assertEquals("Web Services in SOA and MicroServices", course2.getName());
	}	
}
