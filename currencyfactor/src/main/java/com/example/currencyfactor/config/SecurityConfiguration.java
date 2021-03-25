package com.example.currencyfactor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoders;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests()
	 * .antMatchers("/","/currecyconversionfactor/create").authenticated();
	 * 
	 * }
	 */
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/")
					.hasAuthority("SCOPE_services:read").anyRequest().authenticated())
					.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
							.jwt(jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation(
									"https://us-south.appid.cloud.ibm.com/oauth/v4/c3844630-7a07-46b2-aa1f-1fda5651b637"))));
		}
}