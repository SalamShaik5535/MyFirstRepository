package com.Spring.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class HibernateConfig {

	@PersistenceContext
	private EntityManager entityManager;
	
	public HibernateConfig(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	  @Bean
	    public SessionFactory sessionFactory() {
	        return entityManager.unwrap(SessionFactory.class);
	    }
}
