package com.example.demo.emdb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.dao.AddressDao;
import com.example.dao.EmployeeDao;
import com.example.dao.impl.AddressDaoImpl;
import com.example.dao.impl.EmployeeDaoImpl;

@Configuration
@PropertySource("classpath:/application.properties")
public class EmbeddedDBConfiguration {

	@Value("${configuration.class.name}")
	private String configClassName;

	@Bean
	public ApplicationContext applicationContext() {
		return new AnnotationConfigApplicationContext(configClassName);
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScripts(new String[] { "classpath:/schema.sql", "classpath:/data.sql" }).build();
	}

	@Bean
	public AddressDao addressDao() {
		return new AddressDaoImpl();
	}

	@Bean
	public EmployeeDao employeeDao() {
		return new EmployeeDaoImpl();
	}
}
