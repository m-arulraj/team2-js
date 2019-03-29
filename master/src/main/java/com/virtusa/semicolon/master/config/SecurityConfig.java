package com.virtusa.semicolon.master.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	

	@Autowired
	DataSource dataSource;

	@Autowired
	MasterAuthenticatonSuccessHandler masterAuthenticatonSuccessHandler;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/signup", "/about","/register").permitAll().antMatchers("/admin/**")
				.hasRole("ADMIN").antMatchers("/employer/**").hasRole("EMPLOYER").antMatchers("/seeker/**")
				.hasRole("JOBSEEKER").anyRequest().authenticated().and().formLogin().permitAll()
				.successHandler(masterAuthenticatonSuccessHandler)
				.and().exceptionHandling().accessDeniedPage("/access-denied").and().logout().permitAll().and().csrf().disable();
	}

	

}
