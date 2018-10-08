package com.someco.helloworld.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.someco.helloworld.model.User;
import com.someco.helloworld.model.UserProfile;
import com.someco.helloworld.service.UserService;

public class UserAuthenticator implements AuthenticationProvider {

	@Autowired
	UserService userService;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// Without below statement auto wire will not work
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		Session session = sessionFactory.openSession();
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<SimpleGrantedAuthority> auth = new ArrayList<SimpleGrantedAuthority>();
		try {
			User user = userService.findByUserName(userName);
			if(user == null) {
				throw new BadCredentialsException("Not a valid userName");
			}
			
			Set<UserProfile> userProfiles = user.getUserProfiles();
			for(UserProfile userProfile : userProfiles) {
				auth.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType().toString()));
			}
			
			if(!passwordEncoder.matches(password, user.getPassword())) {
				throw new BadCredentialsException("Password is not valid");
			}
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, userName, auth); 
			return token;
		} finally {
			session.close();
		}
		
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}

}
