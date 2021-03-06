package com.example.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		Query query = em.createQuery("SELECT c FROM Course c");
        List resultList = query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
		logger.info("======= Resut ===========");	
	}
	
	@Test
	public void findById_typed() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c -> {}", resultList);
	}
	
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query =
				em.createQuery("select c from Course c where name like '%Expert%'", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Result wehere -> {} ", resultList);
	}
}
