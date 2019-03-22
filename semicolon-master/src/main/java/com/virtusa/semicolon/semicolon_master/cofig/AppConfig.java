package com.virtusa.semicolon.semicolon_master.cofig;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.virtusa.semicolon.*")
public class AppConfig {

	
	@Bean
	public DataSource getDataSource() throws NamingException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/security_app");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
}
