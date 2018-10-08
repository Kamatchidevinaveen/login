package com.someco.helloworld.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/img/**").permitAll()
				.antMatchers("/**")
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
				.and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check") //.defaultSuccessUrl("/home")
				.usernameParameter("username").passwordParameter("password").failureHandler(new SampleAuthenticationFailureHandle()).successHandler(new SampleAuthenticationSuccessHandler())
				.and().logout().addLogoutHandler(new SampleLogoutHandler()).clearAuthentication(true).logoutSuccessUrl("/login?logout").logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.and().csrf().disable().exceptionHandling().accessDeniedPage("/Access_Denied");
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
	      builder.authenticationProvider(new UserAuthenticator());
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}
}
