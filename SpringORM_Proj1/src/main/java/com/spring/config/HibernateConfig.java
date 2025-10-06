package com.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.spring")
public class HibernateConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("JDBC:MYSQL://localhost:3306/salamdb");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.spring.model");
		
		Properties props = new Properties();
		 props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        props.put("hibernate.hbm2ddl.auto", "update");
	        props.put("hibernate.show_sql", "true");

	        factory.setHibernateProperties(props);
	        return factory;
	}
}
