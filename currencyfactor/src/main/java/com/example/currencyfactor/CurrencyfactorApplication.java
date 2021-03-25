package com.example.currencyfactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class CurrencyfactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyfactorApplication.class, args);
	}

}
