package com.virtusa.semicolon.master.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
/*
	@Bean
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://172.25.229.37:3306/semicolon");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("getinside");
	    return driverManagerDataSource;
	}*/
	
	@Bean
    public DataSource dataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //MySQL database we are using
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.25.229.37:3306/semicolon");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("getinside");//change pwd
        return dataSource;
    }
}
