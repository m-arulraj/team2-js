package com.virtusa.semicolon.master.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/* auth.jdbcAuthentication().dataSource(dataSource); */

		
		/*
		 * @SuppressWarnings("deprecation") UserBuilder users =
		 * User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(users.username("shubham").
		 * password("123").roles("EMPLOYEE"))
		 * .withUser(users.username("nagar").password("123").roles("EMPLOYEE",
		 * "MANAGER"))
		 * .withUser(users.username("Sahil").password("123").roles("EMPLOYEE",
		 * "ADMIN"));
		 */
		 

		auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER")
		.and().withUser("emp").password("{noop}123").roles("EMPLOYER")
		.and().withUser("admin").password("{noop}123").roles("ADMIN")		
		.and().withUser("seek").password("{noop}123").roles("SEEKER");

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
		
		http
        .authorizeRequests()
           .antMatchers("/").permitAll()
           .antMatchers("/admin/**").hasRole("ADMIN")
           .antMatchers("/employer/**").hasRole("EMPLOYER")
           .antMatchers("/seeker/**").hasRole("SEEKER")
           .anyRequest().authenticated()
           .and().formLogin().permitAll()
           .and().exceptionHandling().accessDeniedPage("/access-denied");
		
		
	}
}
