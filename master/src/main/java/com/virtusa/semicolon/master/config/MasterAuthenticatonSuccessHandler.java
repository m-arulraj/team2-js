package com.virtusa.semicolon.master.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class MasterAuthenticatonSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
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
			} else if (grantedAuthority.getAuthority().equals("ROLE_JOBSEEKER")) {
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
