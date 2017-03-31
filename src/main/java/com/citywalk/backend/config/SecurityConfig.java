package com.citywalk.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.citywalk.backend.constant.Endpoints;

/**
 * Payment API security configuration
 * @author Guru
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers(Endpoints.API_SECURITY_CONFIG_URL).permitAll().and().formLogin()
				.permitAll();
		httpSecurity.headers().cacheControl().disable();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}
}
