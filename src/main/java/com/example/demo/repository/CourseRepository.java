package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;


@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager entityManager;
	
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			entityManager.persist(course);
		}else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("Web Services Expert");
		entityManager.persist(course1);
		Course course2 = new Course("Angular Expert");
		entityManager.persist(course2);
		
		entityManager.flush();
		
		//entityManager.detach(course1);
		//entityManager.detach(course2);
		
		
		course1.setName("Web Services in SOA and MicroServices");
		entityManager.flush();
		
		course2.setName("Angular2 and ReactJS Expert");
		entityManager.flush();
		
	}

}
