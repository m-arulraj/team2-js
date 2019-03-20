package com.virtusa.semicolon.master.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/* auth.jdbcAuthentication().dataSource(dataSource); */

		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(users.username("shubham").
		 * password("123").roles("EMPLOYEE"))
		 * .withUser(users.username("nagar").password("123").roles("EMPLOYEE",
		 * "MANAGER"))
		 * .withUser(users.username("Sahil").password("123").roles("EMPLOYEE",
		 * "ADMIN"));
		 */

		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER")
		.and().withUser("emp").password("123").roles("EMPLOYER")
				.and().withUser("seek").password("123").roles("SEEKER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests().anyRequest().authenticated()
		 * .antMatchers("/**").hasRole("EMPLOYEE")
		 * .antMatchers("/leaders/**").hasRole("MANAGER")
		 * .antMatchers("/systems/**").hasRole("ADMIN") .and()
		 * .formLogin().loginPage("/customLoginPage")
		 * .loginProcessingUrl("/authenticateTheUser").permitAll().and()
		 * .logout().permitAll()
		 * .and().exceptionHandling().accessDeniedPage("/access-denied");
		 */
		
		http.authorizeRequests().anyRequest().authenticated()
		.antMatchers("/").hasRole("USER")
		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/authenticateUser").permitAll()
		.and().logout().permitAll();

	}
}
