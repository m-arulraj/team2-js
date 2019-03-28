package com.virtusa.semicolon.master.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource);

		
	/*	  auth.jdbcAuthentication().dataSource(dataSource).
		  usersByUsernameQuery(
		  "select USERNAME,PASSWORD, ENABLED from users where USERNAME=?")
		  .authoritiesByUsernameQuery(
		  "select USERNAME, AUTHORITY from authorities where USERNAME=?")
		 ;*/

		/*auth.inMemoryAuthentication().withUser("emp").password("{noop}123").roles("EMPLOYER").and().withUser("emp1")
				.password("{noop}123").roles("EMPLOYER").and().withUser("avenger@gmail.com").password("123")
				.roles("ADMIN").and().withUser("admin").password("{noop}123").roles("ADMIN").and().withUser("seek")
				.password("{noop}123").roles("SEEKER");*/

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/signup", "/about","/register").permitAll().antMatchers("/admin/**")
				.hasRole("ADMIN").antMatchers("/employer/**").hasRole("EMPLOYER").antMatchers("/seeker/**")
				.hasRole("JOBSEEKER").anyRequest().authenticated().and().formLogin().permitAll().and().exceptionHandling()
				.accessDeniedPage("/access-denied").and().logout().permitAll().and().csrf().disable();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)
			throws IOException, ServletException {

		boolean hasAdminRole = false;
		boolean hasEmployerRole = false;
		boolean hasSeekerRole = false;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				hasAdminRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_EMPLOYER")) {
				hasEmployerRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_SEEKER")) {
				hasSeekerRole = true;
				break;
			}

		}

		if (hasAdminRole) {
			redirectStrategy.sendRedirect(req, resp, "/admin");
		} else if (hasEmployerRole) {
			redirectStrategy.sendRedirect(req, resp, "/employer");
		} else if (hasSeekerRole) {
			redirectStrategy.sendRedirect(req, resp, "/seeker");
		} else {
			throw new IllegalStateException();
		}
	}

}
